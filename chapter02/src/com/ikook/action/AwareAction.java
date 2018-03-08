package com.ikook.action;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;

public class AwareAction extends ActionSupport implements ServletRequestAware {

    HttpServletRequest request;

    public void setServletRequest(HttpServletRequest httpServletRequest) {

        this.request = httpServletRequest;

    }

    public String execute() throws Exception {

        request.setAttribute("message", "通过 ServletRequestAware 接口实现了访问 Servlet API");

        return SUCCESS;
    }
}
