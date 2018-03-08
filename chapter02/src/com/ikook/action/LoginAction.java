package com.ikook.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String execute() throws Exception {

        ActionContext actionContext = ActionContext.getContext();

        if ("ikook".equals(username) && "123".equals(password)) {

            actionContext.put("username", username);
            actionContext.put("password", password);

            actionContext.put("success", "用户登录成功");

            return SUCCESS;

        } else {
            actionContext.put("error", "用户登录失败");
            return ERROR;
        }

    }

}