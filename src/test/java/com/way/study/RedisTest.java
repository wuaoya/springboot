package com.way.study;

import com.way.study.redis.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * redis 测试类(测试类包名和上面一致)
 * @Author: wuaoya
 * @Date: 2020-07-15 00:12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTest {
    @Resource
    private RedisUtil redisUtil;

    /**
     * 写入数据
     */
    @Test
    public void set(){
        redisUtil.set("redis_key", "redis_value");
    }
    @Test
    public void get(){
        String value = redisUtil.get("redis_key");
        System.out.println(value);
    }


}
