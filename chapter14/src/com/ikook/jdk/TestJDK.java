package com.ikook.jdk;

import com.ikook.dao.UserDao;

import org.junit.Test;

public class TestJDK {

    @Test
    public void demo01() {

        // 1 从工厂获得指定的内容 (相当于spring获得，但此内容，是代理对象)
        UserDao userDao = MyBeanFactory.getBean();

        // 2 执行方法
        userDao.save();
        userDao.update();
        userDao.delete();
        userDao.find();

    }


}
