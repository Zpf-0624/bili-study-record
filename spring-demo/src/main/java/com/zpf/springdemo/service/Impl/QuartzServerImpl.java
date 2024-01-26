package com.zpf.springdemo.service.Impl;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author zhangpengfei
 * @Date 2023-11-24 16:08
 * @Email zhangpengfei@tuyoogame.com
 * @Description
 */
@Service
public class QuartzServerImpl implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("START DATA BACKUP, current time ：" + data);
    }
}
