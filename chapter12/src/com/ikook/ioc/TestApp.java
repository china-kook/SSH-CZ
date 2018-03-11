package com.ikook.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {

    @Test
    public void demo01() {

        // 定义配置文件的路径（类路径）
        String xmlPath = "applicationContext.xml";

        // 初始化 Spring 容器，加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        // 通过容器获取 userDao 实例
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");

        // 调用 UserDao 的 save() 方法。
        userDao.save();

    }

}
