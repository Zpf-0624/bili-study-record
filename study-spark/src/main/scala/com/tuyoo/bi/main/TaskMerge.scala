package com.tuyoo.bi.main

import com.tuyoo.bi.main.MysqlUtils.{hdfs_path_tmp, hive_sql}

import scala.collection.mutable.ListBuffer

/**
 * @Author zhangpengfei
 * @Date 2024-01-19 11:02
 * @Email zhangpengfei@tuyoogame.com
 * @Description
 */
object TaskMerge extends LogUtil {

    def main(args: Array[String]): Unit = {

        if (args.length != 1) return
        val spark = CommonUtils.getSparkSession(this.getClass.getName)
        val excDay = args(0)
        val tableList = MysqlUtils.getTables(excDay)
        // val excDay = args(0)
        // val tableList = ListBuffer(("event_20453_v4", "2022-01-04"))
        if (tableList.nonEmpty) {
            for ((table, day) <- tableList) {
                val path = String.format(hdfs_path_tmp, table, day)
                log.info("path =>" + path)

                try {
                    val frame = spark.read.format("parquet").load(path)
                    val size = spark.sessionState.executePlan(frame.queryExecution.logical).optimizedPlan.stats.sizeInBytes.toString()
                    val cnt = frame.count()
                    MysqlUtils.setCntSizeOld(table, day, cnt, size)
                } catch {
                    case exception: Exception => log.error(exception)
                }
                try {
                    val hiveSql = String.format(hive_sql, table, day)
                    log.info("hiveSql =>" + hiveSql)
                    val frameMerge = spark.sql(hiveSql)
                    val sizeMerge = spark.sessionState.executePlan(frameMerge.queryExecution.logical).optimizedPlan.stats.sizeInBytes.toString()
                    val cntMerge = frameMerge.count()
                    MysqlUtils.setCntSizeMerge(table, day, cntMerge, sizeMerge)
                } catch {
                    case exception: Exception => log.error(exception)
                }
            }
        }
        spark.stop()
    }

}
