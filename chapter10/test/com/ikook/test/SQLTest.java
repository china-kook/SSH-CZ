package com.ikook.test;

import com.ikook.utils.HibernateUtils;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.List;

public class SQLTest {

    @Test
    public void findAll_sqlTest() {
        // 得到一个Session
        Session session = HibernateUtils.getSession();
        Transaction t = session.beginTransaction();

        // 编写SQL
        SQLQuery sqlQuery = session
                .createSQLQuery("select id,name,age,city from customer");

        //执行查询，获得结果
        List list = sqlQuery.list();

        //循环输出结果
        for (int i = 0; i < list.size(); i++) {  //循环输出集合中的对象
            Object[] objs = (Object[]) list.get(i);//将输出对象放入数组中
            //循环输出数组中的元素
            for (int j = 0; j < objs.length; j++) {
                System.out.print(objs[j] + "  ");
            }
            System.out.println();
        }

        t.commit();
        session.close();
    }

}
