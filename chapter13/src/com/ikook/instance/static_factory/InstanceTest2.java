package com.ikook.instance.static_factory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InstanceTest2 {

    @Test
    public void demo02() {

        String xmlPath = "com/ikook/instance/static_factory/beans2.xml";

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        Bean2 bean2 = (Bean2) applicationContext.getBean("bean2");

        System.out.println(bean2);
    }

}
