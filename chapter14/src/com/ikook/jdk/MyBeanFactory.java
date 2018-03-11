package com.ikook.jdk;

import com.ikook.dao.UserDao;
import com.ikook.dao.UserDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyBeanFactory {

    public static UserDao getBean() {

        // 1. 准备目标类（Spring 创建对象，IoC）
        final UserDao userDao = new UserDaoImpl();

        // 2. 创建 切面类 实例
        final MyAspect myAspect = new MyAspect();

        // 3. 使用代理类， 进行增强， 参数 2：userDao.getClass().getInterfaces();
        return (UserDao) Proxy.newProxyInstance(
                MyBeanFactory.class.getClassLoader(), // 当前类的类加载器
                new Class[]{UserDao.class}, // 要创建实例的实现类的接口
                new InvocationHandler() { // 需要增强的方法
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 前增强
                        myAspect.myBefore();

                        // 目标类的方式
                        Object obj = method.invoke(userDao, args);

                        // 后增强
                        myAspect.myAfter();

                        return obj;
                    }
                }
        );

    }

}
