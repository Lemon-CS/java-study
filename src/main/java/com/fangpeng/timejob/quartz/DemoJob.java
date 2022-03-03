package com.fangpeng.timejob.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Description: TODO
 * @Author : Lemon-CS
 * @Date : 2022年03月03日 11:29 下午
 */
public class DemoJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("我是一个定时任务执行逻辑");
    }
}
