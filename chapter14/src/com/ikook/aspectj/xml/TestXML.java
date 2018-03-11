package com.ikook.aspectj.xml;

import com.ikook.dao.UserDao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestXML {
    @Test
    public void demo01() {

        String xmlPath = "com/ikook/aspectj/xml/applicationContext.xml";

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        // 1 从 spring 容器获得内容
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");

        // 2 执行方法
        userDao.save();
    }
}
