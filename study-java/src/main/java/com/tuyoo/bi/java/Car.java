package com.tuyoo.bi.java;

/**
 * @Author zhangpengfei
 * @Date 2023-09-04 23:55
 * @Email zhangpengfei@tuyoogame.com
 * @Description
 */
public class Car extends Vehicle implements IPower{

    private String carNumber;

    public Car() {
    }

    public Car(String brand, String color, String carNumber) {
        super(brand, color);
        this.carNumber = carNumber;
    }

    @Override
    public void run() {
        System.out.println("小汽车内燃机行驶");
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public void power() {
        System.out.println("小汽车燃油行驶");
    }
}
