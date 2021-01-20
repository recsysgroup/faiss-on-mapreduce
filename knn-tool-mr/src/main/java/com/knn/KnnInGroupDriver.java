package com.knn;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

public class KnnInGroupDriver {
    private static Logger LOG = Logger.getLogger(KnnInGroupDriver.class.getName());

    public static void main(String[] args) throws Exception {
        // instantiate a configuration
        Configuration configuration = new Configuration();

        // instantiate a job
        Job job = Job.getInstance(configuration, "search");

        // set job parameters
        job.setJarByClass(KnnSearchInGroup.class);
        job.setReducerClass(Common.SearchReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        String midOutDir = "/tmp/knn_task/" + UUID.randomUUID().toString();
        LOG.info(String.format("midOutDir is %s", midOutDir));

        MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, KnnSearchInGroup.QueryMapper.class);
        MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, KnnSearchInGroup.SearchMapper.class);
        // set io paths

        FileOutputFormat.setOutputPath(job, new Path(midOutDir));

        Map<String, String> params = new HashMap<>();
        for (String part : args[3].split(",")) {
            String[] kv = part.split("=");
            params.put(kv[0], kv[1]);
        }

        int indexNum = Integer.parseInt(params.getOrDefault("index_num", "1"));
        int searchNum = Integer.parseInt(params.getOrDefault("search_num", "1"));

        job.getConfiguration().setInt("index_num", indexNum);
        job.getConfiguration().setInt("search_num", searchNum);
        job.getConfiguration().setInt("dim",
                Integer.parseInt(params.getOrDefault("dim", "64")));
        job.getConfiguration().setInt("topk",
                Integer.parseInt(params.getOrDefault("topk", "5")));
        job.getConfiguration().set("dis_type", params.getOrDefault("dis_type", "l2"));

        job.setNumReduceTasks(indexNum * searchNum);

        boolean success1 = job.waitForCompletion(true);
        if (!success1) {
            System.exit(1);
        }

        Job job2 = Job.getInstance(configuration, "topk");
        job2.getConfiguration().setInt("topk",
                Integer.parseInt(params.getOrDefault("topk", "5")));
        job2.getConfiguration().set("dis_type",
                params.getOrDefault("dis_type", "l2"));

        // set job parameters
        job2.setJarByClass(KnnMergeTopk.class);
        job2.setMapperClass(KnnMergeTopk.TopkMapper.class);
        job2.setReducerClass(KnnMergeTopk.TopkReducer.class);
        job2.setOutputKeyClass(Text.class);
        job2.setOutputValueClass(Text.class);

        FileInputFormat.addInputPath(job2, new Path(midOutDir));
        FileOutputFormat.setOutputPath(job2, new Path(args[2]));

        boolean success2 = job2.waitForCompletion(true);

        FileSystem hdfs = FileSystem.get(configuration);
        hdfs.deleteOnExit(new Path(midOutDir));

        if (!success2) {
            System.exit(1);
        }
    }
}
