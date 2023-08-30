package com.tuyoo.bi.thread;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Objects;


public class RedisEvent {

    String redisHost = "10.201.30.71";
    Integer redisPort = 6379;
    String redisPassword = "Ij64bfze";
    Integer redisTimeout = 1000000;
    private JedisPool jedisPool;

    public Jedis getRedis(Integer index) {
        if (Objects.isNull(jedisPool)) {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(4);
            config.setMaxIdle(2);
            config.setMaxWaitMillis(1000 * 600);
            jedisPool = new JedisPool(config, redisHost, redisPort, redisTimeout, redisPassword);
            //System.out.println("redisPool =>"+"-"+redisHost+"-"+redisPort+"-"+redisTimeout+"-"+ redisPassword);
        }
        Jedis jedis = jedisPool.getResource();
        jedis.select(index);
        return jedis;
    }


    public void close() {
        jedisPool.close();
    }

}




