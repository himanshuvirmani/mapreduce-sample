package com.sample;

import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by himanshu.virmani on 03/10/16.
 */
@Slf4j
public class WordCount extends Configured implements Tool {


    @Override
    public int run(String[] args) throws Exception {
        String in = "hdfs://localhost:9000/tmp/input.txt";
        String out = "hdfs://localhost:9000/out/" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        Job job = Job.getInstance(getConf(), "word count");
        Configuration conf = getConf();
        log.info("Conf internal conf value " + conf.get("mapreduce.job.reduces"));
        log.info("Conf new conf value " + conf.get("input.path"));
        job.setJarByClass(WordCount.class);
        job.setMapperClass(WordCountMapper.class);
        job.setCombinerClass(WordCountReducer.class);
        job.setReducerClass(WordCountReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        FileInputFormat.addInputPath(job, new Path(conf.get("input.path",in)));
        FileOutputFormat.setOutputPath(job, new Path(conf.get("output.path",out)));
        System.out.println("The output goes to: " + conf.get("output.path",out));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
        return 0;

    }


    public static void main(String[] args) throws Exception {
        int returnValue = 1;
        try {
            returnValue = ToolRunner.run(new WordCount(), args);
        } catch (Exception e) {
            log.error("Exception in main", e);
        } finally {
            System.exit(returnValue);
        }
    }
}
