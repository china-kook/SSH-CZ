package com.ikook.action;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.ServletActionContext;

import java.io.InputStream;

public class SimpleDownLoadAction extends ActionSupport {

    //定义了返回InputStream的方法，该方法作为被下载文件的入口
    public InputStream getDownloadFile() {
//        return ServletActionContext.getServletContext()
//              .getResourceAsStream("/upload/中文文件.txt");
        return ServletActionContext.getServletContext()
                .getResourceAsStream("/upload/Struts2.txt");
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

}
