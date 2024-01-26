package com.tuyoo.bi.test

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.jdbc.JdbcDialects

/**
 * @Author zhangpengfei
 * @Date 2024-01-12 15:55
 * @Email zhangpengfei@tuyoogame.com
 * @Description
 */
object BH {

    private val url = "jdbc:clickhouse://7316468313617076519-public.bytehouse-ce.volces.com/ga_view"
    private val source_table = "ga_event_20435_v4"
    private val user = "pdbi"
    private val password = "SQZ83rZVgD1CNFbj"

    def main(args: Array[String]): Unit = {
        JdbcDialects.registerDialect(ClickHouseDialect)

        val spark = SparkSession.builder()
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

        val df = spark.read
            .format(source = "jdbc")
            .option("url", url)
            .option("driver", "com.clickhouse.jdbc.ClickHouseDriver")
            .option("dbtable", source_table)
            .option("user", user)
            .option("password", password)
            .option("numPartitions", 10)
            .option("partitionColumn", "project_id")
            .option("lowerBound", 0)
            .option("upperBound", 10037)
            .load()

        df.createOrReplaceTempView("test")

        val exeSql =
            """
              |
              | select event,  part_offset, ingest_time, event_time, user_id, project_id,
              |    client_id, device_id, type, properties, lib, app_id, city, country,
              |    game_id, ip_address, network, os_name, os_version, phone_maker,
              |    phone_model, proj_param_1, province, day
              | from test
              | where day between '2023-01-11' and '2023-01-15'
              |
              |""".stripMargin
        spark.sql(exeSql).show(10)
        spark.close()
    }

}


