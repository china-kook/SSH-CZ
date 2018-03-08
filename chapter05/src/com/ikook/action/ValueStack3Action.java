package com.ikook.action;

import com.ikook.domain.Product;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

// 属性驱动
public class ValueStack3Action extends ActionSupport implements ModelDriven<Product>{

    private Product product = new Product();

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    @Override
    public Product getModel() {
        return product;
    }
}
