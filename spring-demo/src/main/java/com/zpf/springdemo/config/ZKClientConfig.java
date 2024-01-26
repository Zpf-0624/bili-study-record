package com.zpf.springdemo.config;

import lombok.Data;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.retry.RetryNTimes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zhangpengfei
 * @Date 2023-11-27 15:47
 * @Email zhangpengfei@tuyoogame.com
 * @Description
 */

@Configuration
@Data
public class ZKClientConfig {

    public static CuratorFramework publishClient;
    @Value("${zookeeper.address}")
    private String connect;
    @Value("${zookeeper.sessionTimeoutMs}")
    private Integer sessionTimeoutMs;
    @Value("${zookeeper.connectionTimeoutMs}")
    private Integer connectionTimeoutMs;

    @Bean("client")
    public CuratorFramework client() {

        ExponentialBackoffRetry retryPolicy = new ExponentialBackoffRetry(3000, 10);
        CuratorFramework zkClient = CuratorFrameworkFactory.builder()
                .connectString(connect)
                .sessionTimeoutMs(sessionTimeoutMs)
                .connectionTimeoutMs(connectionTimeoutMs)
                .retryPolicy(retryPolicy)
                .namespace("ga-archives")
                .build();
        zkClient.start();
        System.out.println("CuratorFramework => client");
        return zkClient;
    }

    @Bean("publishClient")
    public CuratorFramework publishClient() {
        if (publishClient == null) {
            publishClient = CuratorFrameworkFactory.newClient(
                    connect,
                    new RetryNTimes(10, 5000)
            );
            publishClient.start();
        }
        System.out.println("CuratorFramework => publishClient");
        return publishClient;
    }

}
