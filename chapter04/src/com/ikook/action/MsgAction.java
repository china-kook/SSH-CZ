package com.ikook.action;

import com.opensymphony.xwork2.ActionSupport;

public class MsgAction extends ActionSupport {
    public String execute() throws Exception {

        this.addActionError("This is actionerror");
        this.addActionMessage("this is actionmessage");
        this.addFieldError("msg", "this is fielderror");

        return SUCCESS;
    }
}