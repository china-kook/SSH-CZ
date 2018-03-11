package com.ikook.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {

    /**
     * IoC：控制反转。Spring IoC 容器思想的工作机制
     */
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

    /**
     * DI：依赖注入
     */
    @Test
    public void demo02() {

        // 定义配置文件的路径（类路径）
        String xmlPath = "applicationContext.xml";
        // 初始化 Spring 容器，加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        // 通过容器获取 userService 实例
        UserService userService = (UserService) applicationContext.getBean("userService");

        // 调用 userService 的 addUser() 方法
        userService.addUser();

    }

}
