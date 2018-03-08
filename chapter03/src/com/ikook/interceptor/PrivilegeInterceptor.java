package com.ikook.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class PrivilegeInterceptor extends AbstractInterceptor {

    public String intercept(ActionInvocation actionInvocation) throws Exception {

        ActionContext actionContext = actionInvocation.getInvocationContext();// 得到ActionContext.
        Object user = actionContext.getSession().get("user");//获取user对象

        if (user != null) {
            return actionInvocation.invoke(); // 继续向下执行.
        } else {
            actionContext.put("msg", "您还未登录，请先登录");
            return Action.LOGIN; //如果用户不存在，返回login值
        }
    }

}
