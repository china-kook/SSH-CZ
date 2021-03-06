package com.ikook.action;

/**
 * 普通方式
 * <p>
 * 使用注解方式
 * <p>
 * 使用注解方式
 */
//import com.ikook.domain.User;
//import com.ikook.service.UserService;
//import com.opensymphony.xwork2.ActionSupport;
//import com.opensymphony.xwork2.ModelDriven;
//
//public class UserAction extends ActionSupport implements ModelDriven<User> {
//    // 封装数据
//    private User user = new User();
//
//    public User getModel() {
//        return this.user;
//    }
//
//    // *****************************
//    private UserService userService;
//
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
//
//    public String add() {
//        this.userService.saveUser(user);
//        return "add";
//    }
//}


/**
 * 使用注解方式
 */
import com.ikook.domain.User;
import com.ikook.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Namespace("/")
@ParentPackage("struts-default")
@Controller
public class UserAction extends ActionSupport implements ModelDriven<User> {
    // 封装数据
    private User user = new User();

    public User getModel() {
        return this.user;
    }

    // *****************************
    @Autowired
    private UserService userService;

    @Action(value = "userAction_add", results = {@Result(name = "add", location = "/success.jsp")})
    public String add() {
        this.userService.saveUser(user);
        return "add";
    }
}
