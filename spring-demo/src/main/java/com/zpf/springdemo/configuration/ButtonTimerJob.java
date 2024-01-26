package com.zpf.springdemo.configuration;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DisallowConcurrentExecution
public class ButtonTimerJob implements Job{
    private static final Logger logger = LoggerFactory.getLogger(ButtonTimerJob.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.info("--------------定时任务执行逻辑---------------------");
	}
}

