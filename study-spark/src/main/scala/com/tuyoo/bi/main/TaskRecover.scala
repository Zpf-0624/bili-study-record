package com.tuyoo.bi.main

import com.tuyoo.bi.main.MysqlUtils.{hdfs_path, hdfs_path_tmp}
import org.apache.spark.sql.DataFrame

/**
 * @Author zhangpengfei
 * @Date 2024-01-25 14:40
 * @Email zhangpengfei@tuyoogame.com
 * @Description
 */
object TaskRecover extends LogUtil {

    def main(args: Array[String]): Unit = {

        val excDay = args(0)
        val table = args(1)
        val db = args(2)
        if (args.length != 3) return

        val spark = CommonUtils.getSparkSession(this.getClass.getName)
        val path = String.format(hdfs_path, table)
        val sourceDF: DataFrame = spark.read.format("parquet").load(path)
        val sourceFields = sourceDF.schema.map(x => {
            println(x.name)
            x.name
        }).toList
        val targetFields = spark.table(s"$db.$table").schema.map(x => {
            if (sourceFields.contains(x.name)) {
                x.name
            } else {
                String.format("null as %s", x.name.trim)
            }
        }).toList

        sourceDF.createOrReplaceTempView(s"${table}_tmp")
        val sql = s"insert overwrite table $db.$table partition (day, event)  select ${targetFields.mkString(",")} from ${table}_tmp where day = '$excDay'"
        log.info("sql => " + sql)
        // spark.sql(sql)

        spark.close()
    }

}
