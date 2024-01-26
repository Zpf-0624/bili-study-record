package com.zpf.springdemo.controller;

import com.zpf.springdemo.bean.JobInfo;
import com.zpf.springdemo.service.QuartzServer;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Yang
 * @description 任务操作
 * @date 2023/6/28
 */
@RestController
@RequestMapping("/job")
public class QuartzController {

    @Autowired
    private QuartzServer quartzServer;
    @Autowired
    private Scheduler scheduler;

    /**
     * 查询所有的任务
     */
    @GetMapping("/all")
    public List<JobInfo> list() throws SchedulerException {
        List<JobInfo> jobInfos = new ArrayList<>();
        List<String> triggerGroupNames = scheduler.getTriggerGroupNames();
        System.out.println("triggerGroupNames=>"+triggerGroupNames);
        for (String triggerGroupName : triggerGroupNames) {
            Set<TriggerKey> triggerKeySet = scheduler.getTriggerKeys(GroupMatcher.triggerGroupEquals(triggerGroupName));
            System.out.println("triggerKeySet=>"+ triggerKeySet);
            for (TriggerKey triggerKey : triggerKeySet) {
                Trigger trigger = scheduler.getTrigger(triggerKey);
                System.out.println(trigger);
                JobKey jobKey = trigger.getJobKey();
                JobInfo jobInfo = quartzServer.getJobInfo(jobKey.getGroup(), jobKey.getName());
                jobInfos.add(jobInfo);
            }
        }
        return jobInfos;
    }

    /**
     * 添加任务
     */
    @PostMapping("/add")
    public JobInfo addJob(@RequestBody JobInfo jobInfo) throws SchedulerException, ClassNotFoundException {
        quartzServer.addJob(jobInfo);
        return jobInfo;
    }

    /**
     * 暂停任务
     */
    @RequestMapping("/pause")
    public void pauseJob(@RequestParam("jobGroup") String jobGroup, @RequestParam("jobName") String jobName)
            throws SchedulerException {
        quartzServer.pauseJob(jobGroup, jobName);
    }

    /**
     * 暂停任务
     */
    @RequestMapping("/getJob")
    public Object getJob(@RequestParam("jobGroup") String jobGroup, @RequestParam("jobName") String jobName)
            throws SchedulerException {
        return quartzServer.getJobInfo(jobGroup, jobName);
    }

    /**
     * 继续任务
     */
    @RequestMapping("/continue")
    public void continueJob(@RequestParam("jobGroup") String jobGroup, @RequestParam("jobName") String jobName)
            throws SchedulerException {
        quartzServer.continueJob(jobGroup, jobName);
    }

    /**
     * 删除任务
     */
    @RequestMapping("/delete")
    public boolean deleteJob(@RequestParam("jobGroup") String jobGroup, @RequestParam("jobName") String jobName)
            throws SchedulerException {
        return quartzServer.deleteJob(jobGroup, jobName);
    }
}
