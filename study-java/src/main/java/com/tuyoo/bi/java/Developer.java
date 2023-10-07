package com.tuyoo.bi.java;

import lombok.Data;

/**
 * @Author zhangpengfei
 * @Date 2023-09-05 00:01
 * @Email zhangpengfei@tuyoogame.com
 * @Description
 */

@Data
public class Developer {

    private String name;

    private String age;

    public Developer(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public Developer() {
    }

    public void takingVehicle(Vehicle vehicle){
        vehicle.run();
    }
}
