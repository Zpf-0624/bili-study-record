package com.zpf.springdemo.controller;

import com.zpf.springdemo.service.DemoServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhangpengfei
 * @Date 2023-11-21 18:25
 * @Email zhangpengfei@tuyoogame.com
 * @Description
 */

@RestController
@RequestMapping(value = "/demo")
public class DemoController {

    @Autowired
    DemoServer demoServer;

    @GetMapping("/getDemo")
    public Object getDemo(){
        System.out.println("测试 DEMO");
        demoServer.demoClient();
        return true;
    }

}
