package com.leimon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description:
 * @package: com.leimon
 * @className: IntegralCenterServerBackstage.java
 * @author: ext create by zmy
 * @create: 00:06 2022/11/12
 **/
@SpringBootApplication
@MapperScan("com.leimon.dao.mapper")
public class IntegralCenterServerBackstageApplication {
    public static void main(String[] args) {
        SpringApplication.run(IntegralCenterServerBackstageApplication.class, args);
    }
}
