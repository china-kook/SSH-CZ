package com.ikook.annotation;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class UserAction {

    @Resource(name = "userService")
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void save() {
        this.userService.save();
        System.out.println("userAction....save.....");
    }


}
