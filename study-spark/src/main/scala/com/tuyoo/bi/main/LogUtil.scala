package com.tuyoo.bi.main

import org.apache.log4j.{Level, Logger}

trait LogUtil {

    Logger.getLogger("org.apache.spark").setLevel(Level.WARN)

    Logger.getLogger("org.apache.spark.sql").setLevel(Level.WARN)

    val log: Logger = Logger.getLogger(getClass)

}

