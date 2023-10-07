package com.tuyoo.bi.threading;

/**
 * @Author zhangpengfei
 * @Date 2023-09-13 21:44
 * @Email zhangpengfei@tuyoogame.com
 * @Description
 */

public class Test01 {
    public static void main(String[] args) {
        Thread print = new Print();
        print.start();

        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                for (int i = 1; i < 100; i++) {
                    System.out.println(i + Thread.currentThread().getName());
                }
            }
        };

        new Thread(runnable).start();
    }
}

class Print extends Thread{
    @Override
    public void run() {
        for (int i = 1; i < 100 ;i ++) {
            System.out.println(i + Thread.currentThread().getName());
        }
    }
}
