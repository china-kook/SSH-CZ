package com.ikook.instance.factory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InstanceTest3 {

    @Test
    public void demo03() {

        String xmlPath = "com/ikook/instance/factory/beans3.xml";

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        System.out.println(applicationContext.getBean("bean3"));

    }

}
