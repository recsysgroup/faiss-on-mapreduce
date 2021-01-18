package com.knn;

import com.gameofdimension.faiss.swig.IndexFlatL2;
import com.gameofdimension.faiss.swig.floatArray;
import com.gameofdimension.faiss.swig.longArray;
import com.gameofdimension.faiss.utils.JniFaissInitializer;
import com.google.common.base.Preconditions;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

import static com.gameofdimension.faiss.utils.IndexHelper.makeFloatArray;
import static com.gameofdimension.faiss.utils.IndexHelper.show;

public class KnnMergeTopk {
    private static Logger LOG = Logger.getLogger(KnnMergeTopk.class.getName());

    public static class TopkMapper extends Mapper<LongWritable, Text, Text, Text> {
        @Override
        public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

            String[] parts = value.toString().split("\t");
            context.write(new Text(parts[0]), new Text(parts[1]));

        }
    }


    public static class TopkReducer extends Reducer<Text, Text, Text, Text> {
        private int topk;
        private String disType;
        private PriorityQueue<Node> queue;
        private Comparator<Node> comparator;

        static Comparator<Node> ascComparator = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Float.compare(o1.dis, o2.dis);
            }
        };

        static Comparator<Node> descComparator = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Float.compare(o2.dis, o1.dis);
            }
        };

        protected void setup(Reducer<Text, Text, Text, Text>.Context context) throws IOException, InterruptedException {
            topk = context.getConfiguration().getInt("topk", 0);
            disType = context.getConfiguration().get("dis_type", "l2");
            if ("l2".equals(disType)) {
                comparator = ascComparator;
                queue = new PriorityQueue<>(topk, descComparator);
            } else {
                comparator = descComparator;
                queue = new PriorityQueue<>(topk, ascComparator);
            }
        }

        public static class Node implements Comparable<Node> {
            String key;
            float dis;

            public Node(String str) {
                String[] kvs = str.split(":");
                key = kvs[0];
                dis = Float.parseFloat(kvs[1]);
            }

            @Override
            public int compareTo(Node o) {
                return Float.compare(o.dis, dis);
            }

            public String toString() {
                return key + ":" + dis;
            }
        }

        @Override
        public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
            // sum up counts for the key
            queue.clear();

            for (Text val : values) {
                String[] parts = val.toString().split(",");
                for (String str : parts) {
                    Node node = new Node(str);
                    if (queue.size() < topk) {
                        queue.add(node);
                    } else {
                        if (comparator.compare(node, queue.element()) < 0) {
                            queue.remove();
                            queue.add(node);
                        }
                    }
                }
            }

            List<Node> result = new ArrayList<>(queue);
            result.sort(comparator);
            StringBuilder sb = new StringBuilder();
            for (Node node : result) {
                sb.append(",").append(node.toString());
            }
            context.write(key, new Text(sb.substring(1)));
        }
    }

}
