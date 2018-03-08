package com.ikook.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class ValueStackAction extends ActionSupport {

    @Override
    public String execute() throws Exception {
        ValueStack valueStack = ActionContext.getContext().getValueStack();
        System.out.println(valueStack);
        return SUCCESS;
    }
}
