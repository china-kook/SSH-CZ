package com.ikook.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationAssembleTest {

    @Test
    public void annotationTest(){

        String xmlPath = "com/ikook/annotation/beans6.xml";

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        UserAction userAction = (UserAction) applicationContext.getBean("userAction");

        System.out.println(userAction);

        userAction.save();

    }

}
