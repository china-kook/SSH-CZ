package com.ikook.action;

import com.ikook.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserLoginAction extends ActionSupport {
    private User user; //定义User属性

    // user属性的getter和setter方法
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String execute() throws Exception {
        //获取Context对象
        ActionContext context = ActionContext.getContext();
        if ("ikook".equals(user.getUsername())
                && "123".equals(user.getPassword())) {
            //将用户名和密码放入session中
            context.getSession().put("username", user.getUsername());
            context.getSession().put("password", user.getPassword());
            return SUCCESS;
        } else {
            context.getSession().put("error", "用户登录失败！");
            return ERROR;
        }
    }
}

