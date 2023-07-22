package com.tuyoo.bi.Test;

import com.alibaba.fastjson.JSONObject;
import com.tuyoo.bi.java8.Time;
import org.junit.Test;
import lombok.SneakyThrows;
import javax.xml.transform.Source;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author zhangpengfei
 * @Date 2023-03-28 14:51
 * @Email zhangpengfei@tuyoogame.com
 * @Description
 */
public class Test01 {

    public Map<String, String> map = new ConcurrentHashMap<String, String>() {
        {
            {
                put("2", "10010");
                put("3", "6");
                put("4", "132");
                put("9", "28");
                put("10", "20523");
                put("11", "129");
                put("12", "20519");
                put("15", "20458");
                put("16", "20531");
                put("21", "10010");
            }
        }
    };

    @Test
    public void test01() throws InterruptedException {
        //System.out.println(map);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(map);
                }
            }
        };
        runnable.run();
    }

    @Test
    public void test02(){
        System.out.println(map);
        HashMap<String, String> mapTmp = new HashMap<>();
        //Thread.sleep(1000 * 10);
        mapTmp.put("22", "888");
        map = mapTmp;
        System.out.println(map);
    }

    @Test
    public void test03(){
        System.out.println(1 +1);
        try {
            int a = 1/0;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("====");
            System.out.println(e.getLocalizedMessage());
        }
        System.out.println(3);

    }

    @SneakyThrows
    public void Example() {
        int i = 1 / 0;
        System.out.println(i);
    }

    @Test
    public void test04(){
        Example();
        System.out.println(111);

    }

    @Test
    public void test05(){
        String s = "<span style=\"color: #169BD5\">fdasdf</span>";
        System.out.println(s);
    }

    @Test
    public void test06(){
        String s = null;
        System.out.println(JSONObject.parseObject(s));
    }
}
