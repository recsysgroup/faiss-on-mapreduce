package com.knn;

import com.gameofdimension.faiss.swig.*;
import com.gameofdimension.faiss.utils.JniFaissInitializer;
import com.google.common.base.Preconditions;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import static com.gameofdimension.faiss.utils.IndexHelper.makeFloatArray;
import static com.knn.Common.Item;

public class KnnSearchInGroup {
    private static Logger LOG = Logger.getLogger(KnnSearchInGroup.class.getName());

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
            String strValue = value.toString();
            int firstSepIndex = strValue.indexOf(',');
            String group = strValue.substring(0, firstSepIndex);
            Text newValue = new Text("0," + strValue.substring(firstSepIndex + 1));

            for (int searchId = 0; searchId < searchNum; searchId++) {
                context.write(new Text(group + "_" + queryId + "_" + searchId), newValue);
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

            String strValue = value.toString();
            int firstSepIndex = strValue.indexOf(',');
            String group = strValue.substring(0, firstSepIndex);

            Text newValue = new Text("1," + strValue.substring(firstSepIndex + 1));

            for (int queryId = 0; queryId < queryNum; queryId++) {
                context.write(new Text(group + "_" + queryId + "_" + searchId), newValue);
            }

        }
    }
}
