package com.tuyoo.bi.java;

/**
 * @Author zhangpengfei
 * @Date 2023-09-04 23:51
 * @Email zhangpengfei@tuyoogame.com
 * @Description
 */
public class Bicycle extends Vehicle{

    public Bicycle(){

    }

    public Bicycle(String brand, String color) {
        super(brand, color);
    }

    @Override
    public void run() {
        System.out.println("自行车自己骑");
    }
}
