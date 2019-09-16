package com.example.demo.config;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.task.Task1;
import com.example.demo.task.Task2;

@Configuration
public class QuartzConfig {

    /*
     * testTask1使用的固定间隔方式，testTask2使用的是cron表达式方式
     */
    @Bean
    public JobDetail testQuartz1() {
        return JobBuilder.newJob(Task1.class).withIdentity("testTask1").storeDurably().build();
    }

    @Bean
    public Trigger testQuartzTrigger1() {
        //5秒执行一次
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(5)
                .repeatForever();
        return TriggerBuilder.newTrigger().forJob(testQuartz1())
                .withIdentity("testTask1")
                .withSchedule(scheduleBuilder)
                .build();
    }

    @Bean
    public JobDetail testQuartz2() {
        return JobBuilder.newJob(Task2.class).withIdentity("testTask2").storeDurably().build();
    }

    @Bean
    public Trigger testQuartzTrigger2() {
        //cron方式，每隔5秒执行一次
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("*/5 * * * * ?");
        
        return TriggerBuilder.newTrigger().forJob(testQuartz2())
                .withIdentity("testTask2")
                .withSchedule(cronScheduleBuilder)
                .build();
    }
}
