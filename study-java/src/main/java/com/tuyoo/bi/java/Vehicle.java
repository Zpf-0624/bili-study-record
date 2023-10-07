package com.tuyoo.bi.java;

/**
 * @Author zhangpengfei
 * @Date 2023-09-04 23:48
 * @Email zhangpengfei@tuyoogame.com
 * @Description
 */
public abstract class Vehicle {

    private String brand;
    private String color;

    public abstract void run();

    public Vehicle() {
    }

    public Vehicle(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
