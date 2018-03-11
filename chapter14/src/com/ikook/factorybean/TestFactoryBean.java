package com.ikook.factorybean;

import com.ikook.dao.UserDao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactoryBean {

    @Test
    public void demo01() {
        String xmlPath = "com/ikook/factorybean/applicationContext.xml";

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        // 1 从 spring 容器获得内容
        UserDao userDao = (UserDao) applicationContext.getBean("userDaoProxy");

        // 2 执行方法
        userDao.save();
        userDao.update();
        userDao.delete();
        userDao.find();

    }
}
