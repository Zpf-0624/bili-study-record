package com.zpf.springdemo.test;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.quartz.CronExpression;

import java.text.ParseException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Author zhangpengfei
 * @Date 2023-12-16 12:31
 * @Email zhangpengfei@tuyoogame.com
 * @Description
 */

public class test01 {

    @Test
    public void t1() {
        ArrayList<String> objects = new ArrayList<>();
        objects.add("111");
        objects.add("222");
        objects.add("333");
        objects.add("444");
        objects.forEach(x -> {
            if (x == "333") return;
            System.out.println(x);
        });
    }

    @Test
    public void t2() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime dateTimeWithZone = getDateTimeWithZone(now, "+7", "+8");
        System.out.println(dateTimeWithZone);
    }

    public static int dateTimeDiff(String startDay, String endDay) {
        return LocalDateTime.parse(startDay).compareTo(LocalDateTime.parse(endDay));
    }

    public static LocalDateTime getDateTimeWithZone(LocalDateTime inputTime, String inputZone, String outputZone){
        return inputTime.atZone(ZoneId.of(inputZone)).withZoneSameInstant(ZoneId.of(outputZone)).toLocalDateTime();
    }
    
    public static LocalDateTime getDateTimeByDateAndTime(String inputDay, String inputTime){
        LocalDate day = LocalDate.parse(inputDay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalTime time = LocalTime.parse(inputTime, DateTimeFormatter.ofPattern("HH:mm:ss"));
        return LocalDateTime.of(day, time);
    }
    

    public static long getDiffMinute(String cronExp, String standardZoneId, String startDay, String endDay, String triggerTime, String originalZoneId) {
        try {
            // cron 统一转换成东八计算
            CronExpression cronExpression = new CronExpression(cronExp);
            // 获取指定时区当前时间
            LocalDateTime now = LocalDateTime.now(ZoneId.of(standardZoneId));
            // 计算下次触发时间
            Date nextTriggerTime = cronExpression.getNextValidTimeAfter(Date.from(now.toInstant(ZoneOffset.of(standardZoneId))));
            LocalDateTime nextLocalDateTimeTriggerTime = nextTriggerTime.toInstant().atZone(ZoneId.of(standardZoneId)).toLocalDateTime();
            // 判断时间范围
            if (getDateTimeWithZone(getDateTimeByDateAndTime(startDay, triggerTime), originalZoneId, standardZoneId).compareTo(nextLocalDateTimeTriggerTime) < 0
                    && getDateTimeWithZone(getDateTimeByDateAndTime(endDay, triggerTime), originalZoneId, standardZoneId).compareTo(nextLocalDateTimeTriggerTime) > 0) {
                // 计算时间差
                return Duration.between(now, nextLocalDateTimeTriggerTime).toMinutes();
            } else {
                return -1;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return -1;
        }
    }


    public static String generateCronExpression(String type, int second, int minute, int hour, String triggerFrequency) {
        switch (type) {
            case "hour":
                return String.format("%d %d * * * ?", second, minute);
            case "day":
                return String.format("%d %d %d * * ?", second, minute, hour);
            case "week":
                return String.format("%d %d %d ? * %s", second, minute, hour, triggerFrequency);
            case "month":
                return String.format("%d %d %d %s * ?", second, minute, hour, triggerFrequency);
            default:
                return "";
        }
    }

    public static String getCronExpression(String type, String inputDay, String inputTime, String zoneId, String standardZoneId, String triggerFrequency) {
        LocalDate day = LocalDate.parse(inputDay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalTime time = LocalTime.parse(inputTime, DateTimeFormatter.ofPattern("HH:mm:ss"));

        ZonedDateTime standardZoned = LocalDateTime.of(day, time).atZone(ZoneId.of(zoneId)).withZoneSameInstant(ZoneId.of(standardZoneId));

        return generateCronExpression(type,
                standardZoned.getSecond(),
                standardZoned.getMinute(),
                standardZoned.getHour(),
                triggerFrequency);
    }

    public static void zone() {
        // 获取偏移量为+7的时区
        ZoneId zoneId = ZoneId.of("+8");

        // 获取当前在给定时区的日期和时间
        ZonedDateTime dateTime = ZonedDateTime.now(zoneId);

        System.out.println("Current date and time in +07:00 timezone: " + dateTime);
    }

    @Test
    public void t3() {
        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        ZoneId zoneId1 = ZoneId.of("+8");
        System.out.println(zoneId);
        System.out.println(zoneId1);
        System.out.println(LocalDateTime.now(zoneId));
        System.out.println(LocalDateTime.now(zoneId1));
        String day = getCronExpression("day", "2023-11-23", "09:00:00", "+7", "+9", "");
        System.out.println(day);
        // zone();
        System.out.println("===");
        long diffMinute = getDiffMinute("0 0 11 * * ?", "+8", "2023-11-23", "2023-12-23", "09:00:00", "+4");
        System.out.println(diffMinute);
    }

    @Test
    public void t4() {
        String a = "2023-12-05";
        System.out.println(StringUtils.substring(a, 5));

        Integer b = 62;
        System.out.println(String.format("%02d", 62 % 60));
    }


}
