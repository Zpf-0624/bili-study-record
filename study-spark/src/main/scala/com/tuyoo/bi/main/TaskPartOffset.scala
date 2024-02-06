package com.tuyoo.bi.main

import com.tuyoo.bi.main.MysqlUtils.{hdfs_path_tmp, hive_sql}
import com.tuyoo.bi.main.TaskMerge.log

/**
 * @Author zhangpengfei
 * @Date 2024-02-04 10:58
 * @Email zhangpengfei@tuyoogame.com
 * @Description
 */
object TaskPartOffset extends LogUtil {

    def main(args: Array[String]): Unit = {

        if (args.length != 2) return
        val spark = CommonUtils.getSparkSession(this.getClass.getName)
        val day = args(0)
        val table = args(1)

        val path = String.format(hdfs_path_tmp, table, day)
        val frame = spark.read.format("parquet").load(path)
        val cnt = frame.select("part_offset", "event", "event_time").distinct().count()
        log.info(s"path => $path, cnt => $cnt")

        val hiveSql = String.format(hive_sql, table, day)
        val frameMerge = spark.sql(hiveSql)
        val cntMerge = frameMerge.select("part_offset", "event", "event_time").distinct().count()
        log.info(s"hiveSql => $hiveSql, cntMerge => $cntMerge")

        spark.stop()

    }

}
