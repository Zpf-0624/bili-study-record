package com.zpf.springdemo.service;

import org.apache.curator.framework.CuratorFramework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author zhangpengfei
 * @Date 2023-11-27 15:51
 * @Email zhangpengfei@tuyoogame.com
 * @Description
 */

@Service
public class DemoServer {

    @Autowired
    @Resource(name = "client")
    CuratorFramework client;


    @Autowired
    @Resource(name = "publishClient")
    CuratorFramework publishClient;

    public void demoClient(){
        System.out.println(client);
        System.out.println(client.getNamespace());

        System.out.println(publishClient);
        System.out.println(publishClient.getNamespace());

        System.out.println(client);
        System.out.println(client.getNamespace());

    }
}
