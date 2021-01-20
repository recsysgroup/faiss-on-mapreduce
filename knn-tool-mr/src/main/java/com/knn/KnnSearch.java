package com.knn;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.Random;
import java.util.logging.Logger;

import static com.gameofdimension.faiss.utils.IndexHelper.show;

public class KnnSearch {
    private static Logger LOG = Logger.getLogger(KnnSearch.class.getName());

    public static class QueryMapper extends Mapper<LongWritable, Text, Text, Text> {
        private int queryNum = 1;
        private int searchNum = 1;
        private Random random = new Random();

        protected void setup(Mapper<LongWritable, Text, Text, Text>.Context context) throws IOException, InterruptedException {
            queryNum = context.getConfiguration().getInt("query_num", 1);
            searchNum = context.getConfiguration().getInt("search_num", 1);

        }

        @Override
        public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            int queryId = random.nextInt(queryNum);

            Text newValue = new Text("0," + value.toString());

            for (int searchId = 0; searchId < searchNum; searchId++) {
                context.write(new Text(queryId + "_" + searchId), newValue);
            }

        }
    }

    public static class SearchMapper extends Mapper<LongWritable, Text, Text, Text> {
        private int queryNum = 1;
        private int searchNum = 1;
        private Random random = new Random();

        protected void setup(Mapper<LongWritable, Text, Text, Text>.Context context) throws IOException, InterruptedException {
            queryNum = context.getConfiguration().getInt("query_num", 1);
            searchNum = context.getConfiguration().getInt("search_num", 1);

        }

        @Override
        public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            int searchId = random.nextInt(searchNum);

            Text newValue = new Text("1," + value.toString());

            for (int queryId = 0; queryId < queryNum; queryId++) {
                context.write(new Text(queryId + "_" + searchId), newValue);
            }

        }
    }

}
