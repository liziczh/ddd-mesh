package com.liziczh.ddd.mesh.redis.service.impl;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.liziczh.ddd.mesh.redis.service.LockService;

import lombok.extern.slf4j.Slf4j;

/**
 * Redis并发锁服务
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2022/1/16 12:11 上午
 */
@Slf4j
@Service
public class LockServiceImpl implements LockService {

    @Resource(name = "redisStringTemplate")
    private RedisTemplate redisTemplate;

    @Override
    public boolean tryLock(String key) {
        return redisTemplate.opsForValue().setIfAbsent(key, null, 30, TimeUnit.SECONDS);
    }

    @Override
    public void releaseLock(String key) {
        redisTemplate.delete(key);
    }
}
