package com.ikook.ognl;

import ognl.Ognl;
import ognl.OgnlException;

public class TestOgnl01 {

    public static void main(String[] args) throws OgnlException {

        // 创建 User 对象
        User user = new User();

        user.setUsername("ikook");

        // 使用 OGNL 表达式获取 User 对象的 username 值
        System.out.println("username = " + Ognl.getValue("getUsername()", user));

        Group group = new Group();
        group.setName("group");
        user.setGroup(group);

        System.out.println("groupName = " + Ognl.getValue("getGroup().getName()", user));
    }

}
