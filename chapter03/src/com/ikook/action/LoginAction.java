package com.ikook.action;

import com.ikook.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<User>{
    private static final long serialVersionUID = 1L;

    private User user = new User();

    public User getModel() {
        return user;
    }

    public String execute() throws Exception {
        //获取ActionContext
        ActionContext actionContext = ActionContext.getContext();
        if ("tom".equals(user.getUsername())
                && "123".equals(user.getPassword())) {
            // 将用户存储在session中.
            actionContext.getSession().put("user", user);
            return SUCCESS;
        } else {
            actionContext.put("msg", "用户名或密码不正确");
            return INPUT;
        }
    }
}

