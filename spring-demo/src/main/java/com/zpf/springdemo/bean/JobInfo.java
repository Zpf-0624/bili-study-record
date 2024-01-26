package com.zpf.springdemo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobInfo {
    /**
     * 任务名称
     */
    String jobName;

    /**
     * 任务组
     */
    String jobGroup;
    /**
     * 触发器名称
     */
    String triggerName;
    /**
     * 触发器组
     */
    String triggerGroup;
    /**
     * cron表达式
     */
    String cron;
    /**
     * 类名
     */
    String className;
    /**
     * 状态
     */
    String status;
    /**
     * 下一次执行时间
     */
    String nextTime;
    /**
     * 上一次执行时间
     */
    String prevTime;
    /**
     * 配置信息(data)
     */
    String config;


    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getTriggerGroup() {
        return triggerGroup;
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNextTime() {
        return nextTime;
    }

    public void setNextTime(String nextTime) {
        this.nextTime = nextTime;
    }

    public String getPrevTime() {
        return prevTime;
    }

    public void setPrevTime(String prevTime) {
        this.prevTime = prevTime;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }
}
