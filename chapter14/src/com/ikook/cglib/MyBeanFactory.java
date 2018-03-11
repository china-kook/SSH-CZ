package com.ikook.cglib;

import com.ikook.dao.BookDao;
import com.ikook.jdk.MyAspect;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyBeanFactory {

    public static BookDao getBean() {

        // 1 准备目标类(spring 创建对象，IoC)
        final BookDao bookDao = new BookDao();

        // 2 创建 切面类 实例
        final MyAspect myAspect = new MyAspect();

        // 3 生成代理类，cglib 在运行时，生成指定对象的子类，增强
        // 3.1 核心类
        Enhancer enhancer = new Enhancer();

        // 3.2 确定需要增强的类
        enhancer.setSuperclass(bookDao.getClass());

        // 3.3 添加回调函数
        enhancer.setCallback(new MethodInterceptor() {
            // intercept 相当于 jdk invoke , 前三个参数与 jdk invoke 一致
            @Override
            public Object intercept(Object proxy, Method method, Object[] args,
                                    MethodProxy methodProxy) throws Throwable {
                // #1 之前
                myAspect.myBefore();
                // #2 目标方法执行
                Object obj = method.invoke(bookDao, args);
                // #3 之后
                myAspect.myAfter();
                return obj;
            }

        });

        // 3.4 创建代理类
        BookDao bookDaoProxy = (BookDao) enhancer.create();
        return bookDaoProxy;
    }

}
