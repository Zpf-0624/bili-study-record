package com.tuyoo.bi.test

import org.apache.spark.sql.jdbc.JdbcDialect
import org.apache.spark.sql.types._

import java.sql.{JDBCType, SQLException}
import java.util.Locale
import scala.util.matching.Regex

private object ClickHouseDialect extends JdbcDialect {

    private val arrayTypePattern: Regex = """^Array\((.+)\)$""".r
    private val mapTypePattern: Regex = """^Map\((.+)\)$""".r
    private val dateTypePattern: Regex = """^Date$""".r
    private val dateTimeTypePattern: Regex = """^DateTime(64)?(\((.*)\))?$""".r
    private val decimalTypePattern: Regex = """^Decimal\((\d+),\s*(\d+)\)$""".r
    private val decimalTypePattern2: Regex = """^Decimal(32|64|128|256)\((\d+)\)$""".r
    private val enumTypePattern: Regex = """^Enum(8|16)$""".r
    private val fixedStringTypePattern: Regex = """^FixedString\((\d+)\)$""".r
    private val nullableTypePattern: Regex = """^Nullable\((.*)\)""".r
    private val lowCardinalityTypePattern: Regex = """^LowCardinality\((.*)\)""".r

    //override here quoting logic as you wish
    override def quoteIdentifier(colName: String): String = {
        s"`$colName`"
    }

    override def canHandle(url: String): Boolean =
        url.toLowerCase(Locale.ROOT).startsWith("jdbc:clickhouse")

    override def getCatalystType(
                                    sqlType: Int, typeName: String, size: Int, md: MetadataBuilder): Option[DataType] = {
        sqlType match {
            case _ =>
                val (dataType, _) = fromClickHouseType(typeName)
                Some(dataType)
        }
    }

    private def fromClickHouseType(chType: String): (DataType, Boolean) = {
        val (unwrappedChType, nullable) = unwrapNullable(unwrapLowCardinalityTypePattern(chType))
        val catalystType = unwrappedChType match {
            case "String" | "UUID" | fixedStringTypePattern() | enumTypePattern(_) => StringType
            case "Int8" => ByteType
            case "UInt8" | "Int16" => ShortType
            case "UInt16" | "Int32" => IntegerType
            case "UInt32" | "Int64" | "UInt64" | "IPv4" => LongType
            case "Float32" => FloatType
            case "Float64" => DoubleType
            case dateTypePattern() => DateType
            case dateTimeTypePattern(_, _, _) => TimestampType
            case decimalTypePattern(precision, scale) => DecimalType(precision.toInt, scale.toInt)
            case decimalTypePattern2(w, scale) => w match {
                case "32" => DecimalType(9, scale.toInt)
                case "64" => DecimalType(18, scale.toInt)
                case "128" => DecimalType(38, scale.toInt)
                case "256" => DecimalType(76, scale.toInt)
            }
            case arrayTypePattern(nestedChType) =>
                val (_type, _nullable) = fromClickHouseType(nestedChType)
                ArrayType(_type, _nullable)
            case mapTypePattern(_) =>
                StringType
            case _ => throw new SQLException("Unsupported type " + JDBCType.valueOf(chType).getName)

        }
        (catalystType, nullable)
    }

    private def unwrapNullable(maybeNullableType: String): (String, Boolean) =
        maybeNullableType match {
            case nullableTypePattern(typeName) => (typeName, true)
            case _ => (maybeNullableType, false)
        }

    private def unwrapLowCardinalityTypePattern(maybeLowCardinalityType: String): String =
        maybeLowCardinalityType match {
            case lowCardinalityTypePattern(typeName) => typeName
            case _ => maybeLowCardinalityType
        }
}