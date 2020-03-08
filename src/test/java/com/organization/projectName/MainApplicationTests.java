package com.organization.projectName;

import com.organization.projectName.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class MainApplicationTests {


    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void setGetTest() {
        System.out.println(redisUtil.get("name"));
    }

    @Test
    public void delKeyTest() {
        redisUtil.set("name", "shiyanlou");
        redisUtil.del("name");
    }

    @Test
    public void updateTest() {
        redisUtil.set("old", "old");
        redisUtil.del("old");
    }

    @Test
    public void expireTest() {
        redisUtil.set("expireTest", "expireTest");
        redisUtil.expire("expireTest", 10000, TimeUnit.MILLISECONDS);
        redisUtil.del("expireTest");
    }

    @Test
    public void hgetAndHsetTest() {
        redisUtil.hset("shi", "yan", "lou");
        redisUtil.del("shi");
    }

}
