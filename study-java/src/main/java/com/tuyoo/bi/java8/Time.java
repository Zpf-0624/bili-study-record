package com.tuyoo.bi.java8;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * @Author zhangpengfei
 * @Date 2023-03-24 15:25
 * @Email zhangpengfei@tuyoogame.com
 * @Description
 */
public class Time {
    public static String getDateFormat(String day, LocalTime localTime){

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime ldt = LocalDateTime.of(LocalDate.parse(day, fmt1), localTime);

        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return fmt2.format(ldt);
    }

    @Test
    public void test01(){
        String str = "2019-03-03";
        /*DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        long startTimeMill = LocalDateTime.of(LocalDate.parse(str, fmt1), LocalTime.MIN).toInstant(ZoneOffset.of("+8")).toEpochMilli();
        long endTimeMill = LocalDateTime.of(LocalDate.parse(str, fmt1), LocalTime.MAX).toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println(startTimeMill);
        System.out.println(endTimeMill);

        System.out.println( "====");
        LocalDateTime of = LocalDateTime.of(LocalDate.parse(str, fmt1), LocalTime.MIN);
        LocalDateTime of1 = LocalDateTime.of(LocalDate.parse(str, fmt1), LocalTime.MAX);
        System.out.println(of);
        System.out.println(of1);

        System.out.println("===");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timeStr = formatter.format(of);
        String timeStr1 = formatter.format(of1);
        System.out.println("timeStr = " + timeStr);
        System.out.println("timeStr = " + timeStr1);*/

        System.out.println(getDateFormat(str, LocalTime.MIN));
        System.out.println(getDateFormat(str, LocalTime.MAX));

        System.out.println(Math.max(100, 1));




    }
}
