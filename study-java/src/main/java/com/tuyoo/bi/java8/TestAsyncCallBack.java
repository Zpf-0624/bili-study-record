package com.tuyoo.bi.java8;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author zhangpengfei
 * @Date 2023-03-22 15:02
 * @Email zhangpengfei@tuyoogame.com
 * @Description
 */
public class TestAsyncCallBack {
    static ExecutorService es = Executors.newFixedThreadPool(2);

    public static void doSomething(MyCallback callback) {
        // 初始化一个线程
        Thread t = new Thread() {
            public void run() {

                // 这里是业务逻辑处理
                System.out.println("子线任务开始执行:" + Thread.currentThread().getId());
                // 为了能看出效果 ，让当前线程阻塞5秒
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("子线任务结束执行:");
                // 处理完业务逻辑，
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("a1", "子线程处理结果");
                callback.doCallback(params);
            }
        };
        es.execute(t);
        //一定要调用这个方法，不然executorService.isTerminated()永远不为true
        es.shutdown();
    }

    public static void main(String[] args) {
        // 内部类 等价于 new MyCallBack(){...}, 主要作用就是重写doCallback方法
        doSomething((params) -> {
            System.out.println("单个线程也已经处理完毕了，返回参数a1=" + params.get("a1"));
        });

        System.out.println("主线任务已经执行完了:" + Thread.currentThread().getId());
    }
}
