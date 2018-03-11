package com.ikook.assemble;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlBeanAssembleTest {
    @Test
    public void xmlAssembleTest(){
        //定义配置文件路径
        String xmlPath = "com/ikook/assemble/beans5.xml";

        //加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);

        //构造方式输出结果
        System.out.println(applicationContext.getBean("user1"));

        //设值方式输出结果
        System.out.println(applicationContext.getBean("user2"));

    }
}