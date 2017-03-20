package com.learning.spark.examples;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class FirstProgram {
    public static void main(String[] args) {

        //Setup configuration
        String appName = "sparky1";
        String sparkMaster = "local[2]"; // When running on cluster the value of this is fed in from cluster config

        JavaSparkContext spContext = null;

        SparkConf conf = new SparkConf().setAppName(appName)
                .setMaster(sparkMaster);

        //Create spark context from configuration
        spContext = new JavaSparkContext(conf);

        //Read file into RDD
        JavaRDD<String> tweetsRDD = spContext.textFile("data/movietweets.csv");

        //Print first five lines
        for (Object s: tweetsRDD.take(5)) {
            System.out.println(s);
        }

        //Print count

    }
}
