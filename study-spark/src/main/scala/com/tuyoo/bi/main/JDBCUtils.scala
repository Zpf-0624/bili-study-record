package com.tuyoo.bi.main

import java.sql._
import java.util.{Objects, Properties}

/**
 * @Author hantenghui
 * @Date 2021-07-09 18:16
 * @Email hantenghui@tuyoogame.com
 * @Description
 *
 */
object JDBCUtils extends LogUtil {


    /**
     * Acquire jdbc connection with retry
     *
     * @param driverName     jdbc driver name
     * @param url            jdbc url
     * @param jdbcProperties jdbc properties
     * @return succeed -> java.sql.Connection
     *         failed -> null
     */
    def getConnectionByProperties(driverName: String, url: String, jdbcProperties: Properties): Connection = {
        var conn: Connection = null
        try {
            Class.forName(driverName)
            conn = DriverManager.getConnection(url, jdbcProperties)
        } catch {
            case e: SQLException =>
                log.error(s"Something wrong occur when acquire JDBC connection..., Exception: ${e.getLocalizedMessage}")
                getConnectionByProperties(driverName, url, jdbcProperties)
        }
        conn
    }


    /**
     * Acquire jdbc connection with retry
     *
     * @param driverName jdbc driver name
     * @param url        jdbc url
     * @param username   jdbc username
     * @param password   jdbc password
     * @return succeed -> java.sql.Connection
     *         failed -> null
     */
    def getConnection(driverName: String, url: String, username: String = null, password: String = null): Connection = {
        var conn: Connection = null
        try {
            Class.forName(driverName)
            if (Objects.nonNull(username) && Objects.nonNull(password))
                conn = DriverManager.getConnection(url, username, password)
            else
                conn = DriverManager.getConnection(url)
        } catch {
            case e: SQLException =>
                log.error(s"Something wrong occur when acquire JDBC connection..., Exception: ${e.getLocalizedMessage}")
                getConnection(driverName, url, username, password)
        }
        conn
    }


    /**
     * Execute sql by jdbc connection
     *
     * @param connection jdbc connection
     * @param execSql    sql to be executed
     * @return succeed -> null
     *         failed -> error message
     */
    def execute(connection: Connection, execSql: String): String = {

        if (Objects.nonNull(connection)) {
            var statement: Statement = null
            try {
                statement = connection.createStatement()
                statement.execute(execSql)
                return null
            } catch {
                case e: Exception =>
                    log.error(s"Something wrong occur when executing JDBC sql..., Exception: ${e.getLocalizedMessage}")
                    return s"Something wrong occur when executing JDBC sql..., Exception: ${e.getLocalizedMessage}"
            } finally {
                close(connection, statement, null)
            }
        }
        "SQL has not been executed..."
    }


    /**
     * Query by jdbc connection
     *
     * @param connection jdbc connection
     * @param querySql   query sql to be executed
     * @return case class com.tuyoo.bi.config.JDBCQueryResult
     */
    def executeQuery(connection: Connection, querySql: String): JDBCQueryResult = {
        if (Objects.nonNull(connection)) {
            try {
                val statement = connection.createStatement()
                val resultSet = statement.executeQuery(querySql)
                return JDBCQueryResult(connection, statement, resultSet)
            } catch {
                case e: Exception =>
                    log.error(s"Something wrong occur when executing JDBC query..., Exception: ${e.getLocalizedMessage}")
                    return JDBCQueryResult(null, null, null)
            }
        }
        JDBCQueryResult(null, null, null)
    }


    /**
     * Close jdbc resource
     *
     * @param connection jdbc Connection
     * @param statement  jdbc Statement
     * @param resultSet  jdbc ResultSet
     */
    def close(connection: Connection, statement: Statement, resultSet: ResultSet): Unit = {
        try {
            if (Objects.nonNull(resultSet)) resultSet.close()
            if (Objects.nonNull(statement)) statement.close()
            if (Objects.nonNull(connection)) connection.close()
        } catch {
            case e: Exception =>
                log.error(s"Something wrong occur when closing JDBC resource..., Exception: ${e.getLocalizedMessage}")
        }
    }


    /**
     * Close jdbc resource
     *
     * @param jdbcQueryResult case class com.tuyoo.bi.config.JDBCQueryResult
     */
    def close(jdbcQueryResult: JDBCQueryResult): Unit = {
        close(jdbcQueryResult.connection, jdbcQueryResult.statement, jdbcQueryResult.resultSet)
    }

}
