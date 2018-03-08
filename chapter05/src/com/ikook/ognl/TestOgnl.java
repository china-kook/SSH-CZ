package com.ikook.ognl;

import java.util.HashMap;
import java.util.Map;

import ognl.Ognl;
import ognl.OgnlException;

public class TestOgnl {

    public static void main(String[] args) throws OgnlException {

        User user = new User();
        Group group = new Group();
        Branch branch = new Branch();

        branch.setBranchId("BranchId");
        group.setBranch(branch);
        user.setGroup(group);

        // 用 Java 来导航访问
        System.out.println("Java 方式 - " + user.getGroup().getBranch().getBranchId());

        // 利用 OGNL 表达式访问
        System.out.println("OGNL 方式 - " + Ognl.getValue("group.branch.branchId", user));

        user.setUsername("ikook");

        Map context = new HashMap();
        context.put("u", user);

        //输出使用 ognl 表达式获取 context 对象中的 user 对象的 username 值
        System.out.println("获取 Context 中数据结果为 - "
                + Ognl.getValue("#u.username", context, user));

    }

}
