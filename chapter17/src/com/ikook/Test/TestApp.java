package com.ikook.Test;

import com.ikook.domain.User;
import com.ikook.service.UserService;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {
    @Test
    public void demo01() {
        User user = new User();
        user.setUsername("kook");
        user.setPassword("1234");

        String xmlPath = "applicationContext.xml";

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                xmlPath);

        UserService userService = applicationContext.getBean("userService",
                UserService.class);

        userService.saveUser(user);
    }
}
