package com.ikook.action;

import com.ikook.domain.Product;
import com.opensymphony.xwork2.ActionSupport;

// 属性驱动
public class ValueStack2Action extends ActionSupport {

    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
