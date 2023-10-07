package com.tuyoo.bi.java;

/**
 * @Author zhangpengfei
 * @Date 2023-09-04 23:53
 * @Email zhangpengfei@tuyoogame.com
 * @Description
 */
public class ElectricVehicle extends Vehicle implements IPower{


    public ElectricVehicle() {
    }

    public ElectricVehicle(String brand, String color) {
        super(brand, color);
    }

    @Override
    public void run() {
        System.out.println("电动车电机行驶");
    }

    @Override
    public void power() {
        System.out.println("电动车使用动力");
    }
}
