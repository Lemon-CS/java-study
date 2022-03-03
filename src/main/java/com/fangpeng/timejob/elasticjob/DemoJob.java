package com.fangpeng.timejob.elasticjob;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

/**
 * @Description: TODO
 * @Author : Lemon-CS
 * @Date : 2022年03月04日 12:08 上午
 */
public class DemoJob implements SimpleJob {
    @Override
    public void execute(ShardingContext shardingContext) {
        System.out.println("elasticJob -----> 测试任务 ");
    }
}
