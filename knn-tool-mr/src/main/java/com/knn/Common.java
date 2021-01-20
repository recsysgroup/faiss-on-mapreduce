package com.knn;

import com.gameofdimension.faiss.swig.*;
import com.gameofdimension.faiss.utils.JniFaissInitializer;
import com.google.common.base.Preconditions;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.gameofdimension.faiss.utils.IndexHelper.makeFloatArray;

public class Common {
    public static class Item {
        int type;
        String key;
        float[] vec;

        public Item(String str, int dim) throws InterruptedException {
            String[] parts = str.split(",");
            type = Integer.parseInt(parts[0]);
            key = parts[1];
            String[] floatStrParts = parts[2].split(":");
            vec = new float[dim];
            if (floatStrParts.length != dim) {
                throw new InterruptedException(String.format("format not match, dim is %s, parse length is %s", dim, floatStrParts.length));
            }
            for (int i = 0; i < dim; i++) {
                vec[i] = Float.parseFloat(floatStrParts[i]);
            }
        }
    }

    public static class SearchReducer extends Reducer<Text, Text, Text, Text> {
        private int dim;
        private int topk;
        private String disType;

        protected void setup(Reducer<Text, Text, Text, Text>.Context context) throws IOException, InterruptedException {
            dim = context.getConfiguration().getInt("dim", 0);
            topk = context.getConfiguration().getInt("topk", 5);
            disType = context.getConfiguration().get("dis_type", "l2");
            Preconditions.checkArgument(JniFaissInitializer.initialized());

            if (dim <= 0) {
                throw new InterruptedException("dim should be set up");
            }
        }

        @Override
        public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
            // sum up counts for the key

            List<Item> querys = new ArrayList<>();
            List<Item> indexs = new ArrayList<>();

            try {
                for (Text value : values) {
                    Item item = new Item(value.toString(), dim);
                    if (item.type == 0) {
                        querys.add(item);
                    } else if (item.type == 1) {
                        indexs.add(item);
                    }
                }
            } catch (Exception e) {
                throw e;
            }

            if (querys.isEmpty() || indexs.isEmpty()) {
                return;
            }

            if (topk > indexs.size()) {
                topk = indexs.size();
            }

            float[][] xbArray = new float[indexs.size()][];
            for (int index = 0; index < indexs.size(); index++) {
                xbArray[index] = indexs.get(index).vec;
            }
            floatArray xb = makeFloatArray(xbArray);

            IndexFlatL2 quantizer = new IndexFlatL2(dim);
            IndexIVFFlat faissIndex;
            if ("l2".equals(disType)) {
                faissIndex = new IndexIVFFlat(quantizer, dim, 100, MetricType.METRIC_L2);
            } else {
                faissIndex = new IndexIVFFlat(quantizer, dim, 100, MetricType.METRIC_INNER_PRODUCT);
            }
            faissIndex.setNprobe(10);
            Preconditions.checkArgument(!faissIndex.getIs_trained());
            faissIndex.train(indexs.size(), xb.cast());
            Preconditions.checkArgument(faissIndex.getIs_trained());

            faissIndex.add(indexs.size(), xb.cast());

            float[][] xqArray = new float[querys.size()][];
            for (int index = 0; index < querys.size(); index++) {
                xqArray[index] = querys.get(index).vec;
            }
            floatArray xq = makeFloatArray(xqArray);

            floatArray distances = new floatArray(querys.size() * topk);
            longArray indices = new longArray(querys.size() * topk);
            faissIndex.search(querys.size(), xq.cast(), topk, distances.cast(), indices.cast());

            for (int index = 0; index < querys.size(); index++) {
                StringBuilder sb = new StringBuilder();
                for (int rnIndex = 0; rnIndex < topk; rnIndex++) {
                    int row = indices.getitem(index * topk + rnIndex);
                    float dis = distances.getitem(index * topk + rnIndex);
                    sb.append(",").append(indexs.get(row).key)
                            .append(":").append(dis);
                }
                context.write(new Text(querys.get(index).key), new Text(sb.substring(1)));
            }
        }
    }
}
