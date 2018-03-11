package com.ikook.Test;

import com.ikook.domain.User;
import com.ikook.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestApp {

    @Autowired
    private UserService userService;

    @Test
    public void demo01() {
        User user = new User();
        user.setUsername("kook");
        user.setPassword("1234");

//        String xmlPath = "applicationContext.xml";
//
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
//                xmlPath);
//
//        UserService userService = applicationContext.getBean("userService",
//                UserService.class);

        userService.saveUser(user);
    }
}
