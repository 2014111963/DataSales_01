package com.zzc.datasalesprovider.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service("MyRedis")
public class MyRedisImpl implements MyRedis {

    @Autowired
    private StringRedisTemplate template;

    @Override
    public void set(String key, String value) {
        ValueOperations<String, String> operations = template.opsForValue();
        operations.set(key,value);
    }

    @Override
    public void set(String key, String value, int timeout) {
        ValueOperations<String, String> operations = template.opsForValue();
        operations.set(key,value,timeout,TimeUnit.SECONDS);
    }

    @Override
    public String get(String key) {
        ValueOperations<String, String> operations = template.opsForValue();
        return operations.get(key);
    }

    @Override
    public void del(String key) {
        template.delete(key);
    }

    @Override
    public Long incr(String key) {
        ValueOperations<String, String> operations = template.opsForValue();
        Long increment = operations.increment(key,1);
        return increment;
    }

    @Override
    public Long decr(String key) {
        ValueOperations<String, String> operations = template.opsForValue();
        Long increment = operations.increment(key,-1);
        return increment;
    }

    @Override
    public void setExp(String key, int seconds) {
        template.expire(key,seconds,TimeUnit.SECONDS);
    }

    @Override
    public Long getExp(String key) {
        Long expire = template.getExpire(key);
        return expire;
    }

    @Override
    public void lpush(String key, Object value) {
        ListOperations list = template.opsForList();
        list.leftPush(key,value);
    }

    @Override
    public Object rpop(String key) {
        ListOperations opsForList = template.opsForList();
        return opsForList.rightPop(key);
    }

    @Override
    public void hset(String key, String item, String value) {
        HashOperations<String, Object, Object> opsForHash = template.opsForHash();
        opsForHash.put(key,item,value);
    }

    @Override
    public String hget(String key, String item) {
        HashOperations opsForHash = template.opsForHash();
        return (String) opsForHash.get(key,item);
    }

    @Override
    public void hdel(String key, String item) {
        HashOperations opsForHash = template.opsForHash();
        opsForHash.delete(key,item);
    }
}