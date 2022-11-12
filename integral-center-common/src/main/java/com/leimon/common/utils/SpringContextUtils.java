package com.leimon.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

/**
 * @description:
 * @package: com.leimon.common.utils
 * @className: SpringContextUtils.java
 * @author: ext create by zmy
 * @create: 09:23 2022/11/12
 **/
public class SpringContextUtils {
    private static ApplicationContext applicationContext;

    public SpringContextUtils() {
    }

    /**
     * 获取applicationContext对象
     *
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }


    public static void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtils.applicationContext = applicationContext;
    }


    /**
     * 根据 bean 的 name 来查找对象
     *
     * @param beanName bean name
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBeanByName(String beanName) {
        return (T) applicationContext.getBean(beanName);
    }


    /**
     * 根据 bean 的 类型 来查找对象
     *
     * @param requiredType
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBeanByClass(Class<?> requiredType) {
        return (T) applicationContext.getBean(requiredType);
    }
}


