package com.tuyoo.bi.test

import org.apache.hudi.QuickstartUtils._
import org.apache.spark.sql._
import scala.collection.JavaConversions._
import org.apache.hudi.DataSourceWriteOptions._
import org.apache.hudi.config.HoodieWriteConfig._

/**
 * @Author zhangpengfei
 * @Date 2024-01-11 16:49
 * @Email zhangpengfei@tuyoogame.com
 * @Description
 */
object InsertDemo extends Serializable{

    def main(args: Array[String]): Unit = {

        val spark = SparkSession.builder()
            .appName("test")
            .config("spark.sql.adaptive.enabled", "true")
            .config("spark.sql.adaptive.shuffle.targetPostShuffleInputSize", "268435456b")
            .config("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
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


        val tableName = "hudi_test01"
        val basePath = "/Users/tu/Desktop/test/zhangpengfei/hudi_test01"
        val basePathObs = "hdfs://10.201.30.71:8020/user/zhangpengfei/hudi_test01"
        val dataGen = new DataGenerator

        val inserts = convertToStringList(dataGen.generateInserts(10))
        val df = spark.read.json(spark.sparkContext.parallelize(inserts, 2))

        df.write.format("hudi").
            options(getQuickstartWriteConfigs).
            option(PRECOMBINE_FIELD.key(), "ts").
            option(RECORDKEY_FIELD.key(), "uuid").
            option(PARTITIONPATH_FIELD.key(), "partitionpath").
            option(TBL_NAME.key(), tableName).
            mode(saveMode = "overwrite").
            save(basePath)

        df.rdd.saveAsTextFile(basePathObs)

        spark.stop()
    }
}
