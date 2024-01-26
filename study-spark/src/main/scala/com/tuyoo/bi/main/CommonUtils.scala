package com.tuyoo.bi.main

import org.apache.spark.sql.SparkSession

/**
 * @Author hantenghui
 * @Date 2020-08-05 11:23
 * @Email hantenghui@tuyoogame.com
 * @Description
 * 通用方法
 */
object CommonUtils extends GAConfig with LogUtil {


    /**
     * Initializes the sparkSession object
     *
     * @param taskName name of task
     * @return sparkSession
     */
    def getSparkSession(taskName: String, isLocal: Boolean = false): SparkSession = {
        if (isLocal) {
            SparkSession.builder()
                .appName("test")
                .config("spark.sql.adaptive.enabled", "true")
                .config("spark.sql.adaptive.shuffle.targetPostShuffleInputSize", "268435456b")
                .config("spark.sql.merge.output.enabled", "false")
                .config("spark.shuffle.file.buffer", "64k")
                .config("spark.reducer.maxSizeInFlight", "96M")
                .config("spark.sql.small.file.split.size", "268435456")
                .config("spark.sql.small.file.combine", "true")
                .config("spark.driver.host", "localhost")
                .config("spark.sql.broadcastTimeout", "600000")
                .master("local[10]")
                .enableHiveSupport()
                .getOrCreate()
        } else {
            SparkSession.builder()
                .appName(taskName)
                .config("spark.sql.adaptive.enabled", "true")
                .config("spark.sql.adaptive.shuffle.targetPostShuffleInputSize", "268435456b")
                .config("spark.sql.merge.output.enabled", "false")
                .config("spark.shuffle.file.buffer", "64k")
                .config("spark.reducer.maxSizeInFlight", "96M")
                .config("spark.sql.small.file.split.size", "268435456")
                .config("spark.sql.small.file.combine", "true")
                .config("spark.sql.broadcastTimeout", "600000")
                .enableHiveSupport()
                .getOrCreate()
        }
    }




}
