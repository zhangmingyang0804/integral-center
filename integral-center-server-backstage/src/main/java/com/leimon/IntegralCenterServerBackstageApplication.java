package com.leimon;

import com.leimon.common.utils.SpringContextUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

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
        ConfigurableApplicationContext applicationContext = SpringApplication.run(IntegralCenterServerBackstageApplication.class, args);
        SpringContextUtils.setApplicationContext(applicationContext);
    }
}
