package com.tuyoo.bi.java8;

/**
 * @Author zhangpengfei
 * @Date 2023-03-22 14:57
 * @Email zhangpengfei@tuyoogame.com
 * @Description
 */

import java.util.concurrent.*;

/**
 * Futures是一个抽象的概念，它表示一个值，该值可能在某一点变得可用。一个Future要么获得计算完的结果，要么获得计算失败后的异常
 * 每传递一个Runnable对象到ExecutorService.submit()方法就会得到一个回调的Future,你能使用它检测是否执行，这种方法可以是同步等待线处理结果
 */
public class TestFuture {
    public static void main(String[] args) {
        Callable<Result> callable = new Callable<Result>() {
            @Override
            public Result call() throws Exception {
                //这里是业务逻辑处理
                //让当前线程阻塞1秒看下效果
                Thread.sleep(5000);
                return new Result("张三");
            }
        };
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Future<Result> resultFuture = executorService.submit(callable);
        executorService.shutdown();

        /**
         * 无限循环等待任务处理完毕  如果已经处理完毕 isDone返回true
         */
        while (!resultFuture.isDone()) {
            try {
                Result result = resultFuture.get(); // 在这一步阻塞知直到得到子线程返回结果
                System.out.println(result.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}



