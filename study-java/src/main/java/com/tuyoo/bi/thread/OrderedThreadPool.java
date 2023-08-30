package com.tuyoo.bi.thread;

import java.util.concurrent.*;

public class OrderedThreadPool {
    private final ExecutorService executorService;

    public OrderedThreadPool(int poolSize, int queueSize) {
        this.executorService = new ThreadPoolExecutor(poolSize, poolSize, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(queueSize));
    }

    public void submitTask(Runnable task) {
        executorService.submit(task);
    }

    public void shutdown() {
        executorService.shutdown();
    }

    public static void main(String[] args) {
        int poolSize = 10; // 线程池大小
        int queueSize = 10; // 队列大小
        OrderedThreadPool threadPool = new OrderedThreadPool(poolSize, queueSize);

        // 创建一系列需要按顺序执行的任务
        for (int i = 0; i < 10; i++) {
            int taskId = i + 1; // 任务ID
            threadPool.submitTask(() -> {
                System.out.println("Executing Task " + taskId + Thread.currentThread());
                // 执行具体的任务操作
            });
        }

        threadPool.shutdown();
    }
}