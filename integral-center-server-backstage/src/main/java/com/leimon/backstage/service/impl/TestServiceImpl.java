package com.leimon.backstage.service.impl;

import com.leimon.backstage.service.TestService;
import com.leimon.common.utils.RedisUtils;
import com.leimon.dao.mapper.TestMapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @package: com.leimon.backstage.service.impl
 * @className: TestServiceImpl.java
 * @author: ext create by zmy
 * @create: 21:47 2022/11/11
 **/
@Service
@Slf4j
public class TestServiceImpl implements TestService {
    public static final Logger LOGGER = LoggerFactory.getLogger(TestServiceImpl.class);

    @Resource
    private TestMapper testMapper;

    @Override
    public Map<String, Object> test(Map<String, Object> param) {
        String key = "00000000000";
        String value = "dddddddddddddddddddddddddddddd";
        RedisUtils.setKey(key, value);
        String value1 = RedisUtils.getValue(key);
        log.info("value{}==============================", value1);
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("data", value1);
        return resMap;
    }
}
