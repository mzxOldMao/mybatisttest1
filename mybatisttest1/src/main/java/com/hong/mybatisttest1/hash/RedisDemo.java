package com.hong.mybatisttest1.hash;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisDemo {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void redis(){
        redisTemplate.opsForValue().set("毛","mao");
        System.out.println(redisTemplate.opsForValue().get("address"));
        System.out.println(redisTemplate.opsForValue().get("毛"));

    }
}
