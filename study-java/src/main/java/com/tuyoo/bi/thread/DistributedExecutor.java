package com.tuyoo.bi.thread;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DistributedExecutor {
    private final Executor executorService;
    private final CuratorFramework curatorFramework;
    private static final String LOCK_PATH = "/ga_project/approve_status_queue";

    public DistributedExecutor(int poolSize, CuratorFramework curatorFramework) {
        this.executorService = Executors.newFixedThreadPool(poolSize);
        this.curatorFramework = curatorFramework;
    }

    public void submitTask(Runnable task) {
        InterProcessMutex lock = new InterProcessMutex(curatorFramework, LOCK_PATH);
        try {
            lock.acquire();
            /*executorService.execute(() -> {
                try {
                    task.run();
                } catch (Exception e) {
                    // 处理异常
                }
            });*/
            task.run();
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                lock.release();
            } catch (Exception e) {
                // 处理异常
            }
        }

    }
/*
    public void shutdown() {
        executorService.shutdown();
    }*/
}