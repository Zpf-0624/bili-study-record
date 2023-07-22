package com.tuyoo.bi.java8;

import lombok.Data;

/**
 * @Author zhangpengfei
 * @Date 2023-03-22 23:03
 * @Email zhangpengfei@tuyoogame.com
 * @Description
 */

@Data
public class Employee {

    public String name;
    public Integer age;
    public Integer salary;
    public Status status;

    public Employee(String name, Integer age, Integer salary, Status status) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.status = status;
    }
}
