package cn.hyperchain.ink.core.system.redis;

import cn.hyperchain.ink.core.constant.RedisCacheType;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhangrui on 2018/11/15.
 */
@Component
@Slf4j
public class RedisUtils {

    /**
     * 私有构造函数
     */
    public RedisUtils() {
        super();
    }

    /**
     * 注入RedisTemplate
     */

    private RedisTemplate<String, Object> redisTemplate;

    private ValueOperations<String, String> valueOperations;

    private HashOperations<String, String, Object> hashOperations;

    private ListOperations<String, Object> listOperations;

    private SetOperations<String, Object> setOperations;

    private ZSetOperations<String, Object> zSetOperations;

    @Autowired
    public RedisUtils(
            RedisTemplate<String, Object> redisTemplate,
            ValueOperations<String, String> valueOperations,
            HashOperations<String, String, Object> hashOperations,
            ListOperations<String, Object> listOperations,
            SetOperations<String, Object> setOperations,
            ZSetOperations<String, Object> zSetOperations) {
        this.redisTemplate = redisTemplate;
        this.valueOperations = valueOperations;
        this.hashOperations = hashOperations;
        this.listOperations = listOperations;
        this.setOperations = setOperations;
        this.zSetOperations = zSetOperations;
    }


    /**
     * 默认过期时长，单位：秒
     */
    private final static long DEFAULT_EXPIRE = 60 * 60 * 24 * 1000;
    /**
     * 不设置过期时长
     */
    public final static long NOT_EXPIRE = -1;


//    private final static Gson gson = new Gson();


    public void set(String key, Object value) {
        valueOperations.set(key, toJson(value));
    }

    public void set(String key, Object value, long expire, TimeUnit timeUnit) {
        valueOperations.set(key, toJson(value));
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(key, expire, timeUnit);
        }
    }

    /**
     * 设置key value 和过期时间
     *
     * @param key
     * @param value  基本类型将不会json化，对象将会json化
     * @param expire -1代表无过期时间；
     */
    public void set(String key, Object value, long expire) {
        valueOperations.set(key, toJson(value));
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
    }

    /**
     * 设置 key value 默认过期时间 24h
     *
     * @param key
     * @param value
     */

    public void setDefaultExpire(String key, Object value) {
        set(key, value, DEFAULT_EXPIRE);
    }

    public <T> T get(String key, Class<T> clazz, long expire) {
        String value = valueOperations.get(key);
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return value == null ? null : fromJson(value, clazz);
    }

    /**
     * 获取对象类型value
     *
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T get(String key, Class<T> clazz) {
        return get(key, clazz, NOT_EXPIRE);
    }

    /**
     * 获取基本类型value
     *
     * @param key
     * @param expire
     * @return
     */
    public String get(String key, long expire) {
        String value = valueOperations.get(key);
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return value;
    }

    public String get(String key) {
        return get(key, NOT_EXPIRE);
    }

    public String get(String key, RedisCacheType redisCacheType) {
        return get(redisCacheType.getMsg() + ":" + key, NOT_EXPIRE);
    }

    public <T> T get(String key, RedisCacheType redisCacheType, Class<T> clazz) {
        return get(redisCacheType.getMsg() + ":" + key, clazz, NOT_EXPIRE);
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }

    public void delete(String key, RedisCacheType redisCacheType) {
        redisTemplate.delete(redisCacheType.getMsg() + ":" + key);
    }


//  list操作

    public void setRpush(String key, String... strings) {
        listOperations.rightPushAll(key, strings);
    }


    public void setLpush(String key, String... strings) {
        listOperations.leftPushAll(key, strings);
    }

    public boolean lock(String id, RedisCacheType redisCacheType) {
        long time = System.currentTimeMillis() + DEFAULT_EXPIRE;
        return lock(id, redisCacheType, time + "");
    }

    /**
     * 加锁
     *
     * @param id        id - 唯一标志
     * @param timeStamp 当前时间+超时时间 也就是时间戳
     * @return
     */
    public boolean lock(String id, RedisCacheType redisCacheType, String timeStamp) {
        String targetId = redisCacheType.getMsg() + ":" + id;
        if (valueOperations.setIfAbsent(targetId, timeStamp)) {
            // 对应setnx命令，可以成功设置,也就是key不存在
            return true;
        }

        // 判断锁超时 - 防止原来的操作异常，没有运行解锁操作  防止死锁
        String currentLock = valueOperations.get(targetId);
        // 如果锁过期 currentLock不为空且小于当前时间
        if (!StringUtils.isEmpty(currentLock) && Long.parseLong(currentLock) < System.currentTimeMillis()) {
            // 获取上一个锁的时间value 对应getset，如果lock存在
            String preLock = valueOperations.getAndSet(targetId, timeStamp);

            // 假设两个线程同时进来这里，因为key被占用了，而且锁过期了。获取的值currentLock=A(get取的旧的值肯定是一样的),两个线程的timeStamp都是B,key都是K.锁时间已经过期了。
            // 而这里面的getAndSet一次只会一个执行，也就是一个执行之后，上一个的timeStamp已经变成了B。只有一个线程获取的上一个值会是A，另一个线程拿到的值是B。
            if (!StringUtils.isEmpty(preLock) && preLock.equals(currentLock)) {
                // preLock不为空且preLock等于currentLock，也就是校验是不是上个对应的商品时间戳，也是防止并发
                return true;
            }
        }
        return false;
    }

    /**
     * 解锁
     *
     * @param id
     * @param timeStamp
     */
    public void unlock(String id, RedisCacheType redisCacheType, String timeStamp) {
        String target = redisCacheType.getMsg() + ":" + id;
        try {
            String currentValue = valueOperations.get(target);
            if (!StringUtils.isEmpty(currentValue) && currentValue.equals(timeStamp)) {
                // 删除锁状态
                valueOperations.getOperations().delete(target);
            }
        } catch (Exception e) {
            log.error("解锁异常{}", e);
        }
    }

    /**
     * 解锁
     *
     * @param id
     */
    public void unlock(String id, RedisCacheType redisCacheType) {
        String target = redisCacheType.getMsg() + ":" + id;
        try {
            String currentValue = valueOperations.get(target);
            if (!StringUtils.isEmpty(currentValue)) {
                // 删除锁状态
                valueOperations.getOperations().delete(target);
            }
        } catch (Exception e) {
            log.error("解锁异常{}", e);
        }
    }

    /**
     * Object转成JSON数据
     */
    private String toJson(Object object) {
        if (object instanceof Integer || object instanceof Long || object instanceof Float ||
                object instanceof Double || object instanceof Boolean || object instanceof String) {
            return String.valueOf(object);
        }
        return JSON.toJSONString(object);
    }

    /**
     * JSON数据，转成Object
     */
    private <T> T fromJson(String json, Class<T> clazz) {
        return JSONObject.toJavaObject(JSONObject.parseObject(json), clazz);
    }

}
