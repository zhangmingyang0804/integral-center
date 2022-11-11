package com.leimon.backstage.service.impl;

import com.leimon.backstage.service.TestService;
import com.leimon.dao.mapper.TestMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @package: com.leimon.backstage.service.impl
 * @className: TestServiceImpl.java
 * @author: ext create by zmy
 * @create: 21:47 2022/11/11
 **/
@Service
public class TestServiceImpl implements TestService {
    public static final Logger LOGGER = LoggerFactory.getLogger(TestServiceImpl.class);

    @Resource
    private TestMapper testMapper;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public Map<String, Object> test(Map<String, Object> param) {
        String key = "00000000000";
        String value = "dddddddddddddddddddddddddddddd";
        redisTemplate.opsForValue().set(key, value, 10, TimeUnit.SECONDS);
        Map<String, Object> resMap = new HashMap<>();
        String s = redisTemplate.opsForValue().get(key);
        resMap.put("data", s);
        return resMap;
    }
}
