package com.ikook.action;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.ServletActionContext;

public class MessageAction extends ActionSupport {

    public String execute() throws Exception {
        ServletActionContext.getRequest()
                .setAttribute("message", "通过 ServletActionContext 类直接访问 Servlet API");
        return SUCCESS;
    }
}
