package com.tuyoo.bi.java;

/**
 * @Author zhangpengfei
 * @Date 2023-09-04 23:50
 * @Email zhangpengfei@tuyoogame.com
 * @Description
 */
public class VehicleTest {

    class Test{
    }

    public static void main(String[] args) {

        Developer developer = new Developer();

        Vehicle[] vehicles = new Vehicle[3];

        vehicles[0] = new Bicycle("自行车", "红");
        vehicles[1] = new ElectricVehicle("电动车", "蓝");
        vehicles[2] = new Car("奔驰", "绿", "8888");

        for (Vehicle vehicle : vehicles) {
             developer.takingVehicle(vehicle);
             if (vehicle instanceof IPower) {
                 ((IPower) vehicle).power();
             }
        }

        IPower.method();



    }

    public Comparable getComoarable(){
        return new Comparable(){
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };
    }

}

