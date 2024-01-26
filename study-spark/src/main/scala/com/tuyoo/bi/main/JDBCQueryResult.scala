package com.tuyoo.bi.main

import java.sql.{Connection, ResultSet, Statement}

/**
 * @Author hantenghui
 * @Date 2021-07-09 18:17
 * @Email hantenghui@tuyoogame.com
 * @Description
 */
case class JDBCQueryResult(connection: Connection, statement: Statement, resultSet: ResultSet)
