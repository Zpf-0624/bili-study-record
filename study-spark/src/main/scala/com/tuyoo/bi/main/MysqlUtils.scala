package com.tuyoo.bi.main

import java.sql._
import scala.collection.mutable.ListBuffer

/**
 * @Author hantenghui
 * @Date 2020-08-25 17:35
 * @Email hantenghui@tuyoogame.com
 * @Description
 *
 */
object MysqlUtils extends LogUtil with GAConfig {

    private val driver = "com.mysql.jdbc.Driver"
    private val database = "dc_manager"
    private val mysqlTableName = "convert_task_status_v4_snappy_record"
    private val localUrl = "jdbc:mysql://localhost:3306/dc_manager?useSSL=false"
    private val localUsername = "root"
    private val localPassword = "123456"
    private val url = "jdbc:mysql://10.201.1.250:3306/dc_manager?useSSL=false"
    private val username = "dcweb"
    private val password = "TuYougame2018!"


    def getConnection(isLocal: Boolean = false): Connection = {
        if (isLocal) {
            JDBCUtils.getConnection(driver, localUrl, localUsername, localPassword)
        } else {
            JDBCUtils.getConnection(driver, url, username, password)
        }
    }


    def setCntSizeMerge(tableName: String, day: String, cnt: Long, size: String, isLocal: Boolean = false): Unit = {
        val execSql =
            s"""
               |update $database.$mysqlTableName
               |    set
               |        cnt_merge = $cnt,
               |        size_merge = '$size'
               |    where table_name = '$tableName'
               |    and day = '$day'
                """.stripMargin
        val connection = getConnection(isLocal)
        JDBCUtils.execute(connection, execSql)
    }


    def setCntSizeOld(tableName: String, day: String, cnt: Long, size: String, isLocal: Boolean = false): Unit = {
        val execSql =
            s"""
               |update $database.$mysqlTableName
               |    set
               |        cnt = $cnt,
               |        size = '$size'
               |    where table_name = '$tableName'
               |    and day = '$day'
                """.stripMargin
        val connection = getConnection(isLocal)
        JDBCUtils.execute(connection, execSql)
    }


    def getTables(day: String): ListBuffer[(String, String)] = {
        val taskStatus: ListBuffer[(String, String)] = ListBuffer()
        val querySql =
            s"""
               |select distinct table_name,day from dc_manager.convert_task_status_v4_snappy_record
               |    where day = '$day'
               |    and (cnt = 0 or cnt is null)
              """.stripMargin
        try {
            val connection = getConnection()
            val jDBCQueryResult = JDBCUtils.executeQuery(connection, querySql)
            val rs = jDBCQueryResult.resultSet
            while (rs.next()) {
                val tableName = rs.getString("table_name")
                val day = rs.getString("day")
                taskStatus += ((tableName, day))
            }
            JDBCUtils.close(jDBCQueryResult)
        } catch {
            case e: SQLException =>
                log.error(s"查询 convert_task_status_v4_snappy_record  任务 状态失败 ${e.getLocalizedMessage}")
        }
        taskStatus
    }

}
