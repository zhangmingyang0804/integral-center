package com.leimon.dao.mapper;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @package: com.leimon.dao.mapper
 * @className: TestMapper.java
 * @author: ext create by zmy
 * @create: 22:12 2022/11/11
 **/
public interface TestMapper {
    List<Map<String, Object>> selectAll();

    List<Map<String, Object>> selectMany();
}
