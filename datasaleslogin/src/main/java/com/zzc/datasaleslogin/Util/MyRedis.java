package com.zzc.datasaleslogin.Util;

public interface MyRedis {

    public void set(String key,String value);

    public void set(String key,String value,int timeout);

    public String get(String key);

    public void del(String key);

    public Long incr(String key);

    public Long decr(String key);

    public void setExp(String key,int seconds);

    public Long getExp(String key);

    public void lpush(String key,Object value);

    public Object rpop(String key);

    public void hset(String key,String item,String value);

    public String hget(String key,String item);

    public void hdel(String key,String item);
}
