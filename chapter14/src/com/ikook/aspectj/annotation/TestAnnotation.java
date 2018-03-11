package com.ikook.aspectj.annotation;

import com.ikook.dao.UserDao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/ikook/aspectj/annotation/applicationContext.xml")
public class TestAnnotation {

    @Autowired
    private UserDao userDao;

    @Test
    public void demo01() {
        userDao.delete();
    }
}
