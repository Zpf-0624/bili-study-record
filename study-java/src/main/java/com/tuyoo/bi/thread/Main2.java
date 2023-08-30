package com.tuyoo.bi.thread;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.imps.CuratorFrameworkImpl;
import org.apache.curator.retry.RetryNTimes;
import redis.clients.jedis.Jedis;

import java.util.List;

public class Main2 {

    public static CuratorFramework curator() {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient("10.201.30.129:2181,10.201.30.193:2181,10.201.30.71:2181",
                new RetryNTimes(10, 5000) );
        curatorFramework.start();
        return curatorFramework;
    }

    public static void main(String[] args) {


        DistributedExecutor distributedExecutor = new DistributedExecutor(2, curator());
        RedisEvent redisEvent = new RedisEvent();

        Jedis redis = redisEvent.getRedis(1);
        while (true) {
            System.out.println("main2" );
            List<String> result = redis.brpop(0, "approve_status_queue");

            if (!result.isEmpty()){
                distributedExecutor.submitTask(() -> {
                    System.out.println("Executing Task " + result + "  " + Thread.currentThread());
                    // 执行具体的任务操作
                    System.out.println();
                });
            } else {
                System.out.println("没有数据");
            }
        }

    }
}