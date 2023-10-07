package com.tuyoo.bi.java8;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Optional;

import static java.lang.Thread.sleep;

/**
 * @Author zhangpengfei
 * @Date 2023-03-21 17:33
 * @Email zhangpengfei@tuyoogame.com
 * @Description
 */
public class Test01 {

    @Test
    public void test01(){
        System.out.println("123adf");
    }

    @Test
    public void test02(){
        SumInterface s = () -> System.out.println("111");
        s.sum();
    }

    public static void main(String[] args) {
        Boolean a = false;
        System.out.println(a);

        System.out.println(Optional.ofNullable(a).isPresent());

        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
    }

}
