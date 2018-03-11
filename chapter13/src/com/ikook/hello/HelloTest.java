package com.ikook.hello;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloTest {

    @Test
    public void hello() {

        String xmlPath = "com/ikook/hello/beans4.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        System.out.println(applicationContext.getBean("hello"));
        System.out.println(applicationContext.getBean("hello"));
    }

}
