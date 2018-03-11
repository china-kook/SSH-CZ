package com.ikook.test;

import com.ikook.service.AccountService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        // 获得容器，并操作
        /*
        String xmlPath = "applicationContext.xml";

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                xmlPath);

        AccountService accountService = (AccountService) applicationContext.getBean("accountServiceProxy");

        accountService.transfer("jack", "rose", 100);

        System.out.println("ok");
        */

        //********************************基于xml方式********************************************************
        /*
        String xmlPath = "applicationContext_xml.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                xmlPath);

        AccountService accountService = (AccountService) applicationContext
                .getBean("accountService");

        accountService.transfer("jack", "rose", 100);
        System.out.println("ok");
        */

        //*********************************基于注解的方式******************************************************

        String xmlPath = "applicationContext_annotation.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                xmlPath);

        AccountService accountService = (AccountService) applicationContext
                .getBean("accountService");


        accountService.transfer("jack", "rose", 100);

        System.out.println("ok");

    }
}
