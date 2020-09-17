package com.way.study.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * redis工具类
 * @Author: wuaoya
 * @Date: 2020-07-14 23:42
 */
@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    /**
     * 读取缓存
     * @param key
     * @return
     */
    public String get(final String key){
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 写入缓存
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, String value){
        boolean result = false;
        try {
            redisTemplate.opsForValue().set(key, value);
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 删除缓存
     * @param key
     * @return
     */
    public boolean delete(final String key){
        boolean result = false;
        try{
            redisTemplate.delete(key);
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}

