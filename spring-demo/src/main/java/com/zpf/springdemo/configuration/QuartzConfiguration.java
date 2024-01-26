package com.zpf.springdemo.configuration;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;



@Configuration
public class QuartzConfiguration {

    @Autowired
    @Resource(name = "dataSource")
    DataSource dataSource;


    @Bean
    public Properties quartzProperties() throws IOException {
        Properties prop = new Properties();
        prop.put("quartz.scheduler.instanceName", "DefaultQuartzScheduler");
        prop.put("org.quartz.scheduler.skipUpdateCheck", "true");
        prop.put("org.quartz.scheduler.instanceId", "AUTO");
        prop.put("org.quartz.scheduler.jobFactory.class", "org.quartz.simpl.SimpleJobFactory");
        prop.put("org.quartz.jobStore.class", "org.quartz.impl.jdbcjobstore.JobStoreTX");
        prop.put("org.quartz.jobStore.driverDelegateClass", "org.quartz.impl.jdbcjobstore.StdJDBCDelegate");
        prop.put("org.quartz.jobStore.dataSource", "quartzDataSource");
        prop.put("org.quartz.jobStore.tablePrefix", "QRTZ_");
        prop.put("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
        prop.put("org.quartz.threadPool.threadCount", "5");
        prop.put("org.quartz.threadPool.threadPriority", "8");
        return prop;
    }


    @Bean
    public JobFactory buttonJobFactory(ApplicationContext applicationContext) {
        AutoWiredSpringBeanToJobFactory jobFactory = new AutoWiredSpringBeanToJobFactory();
        jobFactory.setApplicationContext(applicationContext);
        return jobFactory;
    }


    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(JobFactory buttonJobFactory) throws IOException {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setSchedulerName("demo_zpf");
        factory.setJobFactory(buttonJobFactory);
        factory.setOverwriteExistingJobs(true);
        factory.setAutoStartup(true); // 设置自行启动
        factory.setQuartzProperties(quartzProperties());
        factory.setDataSource(dataSource);// 使用应用的dataSource替换quartz的dataSource
        return factory;
    }

    @Bean
    public Scheduler scheduler(SchedulerFactoryBean schedulerFactoryBean) throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        scheduler.start();
        return scheduler;
    }


}

