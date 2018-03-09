package com.ikook.test;

import com.ikook.domain.Customer;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.List;

/**
 * Query查询
 */
public class QueryTest {

    /**
     * 使用Query查询全部
     */
    @Test
    public void findAll_hqlTest() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // 编写 HQL
        String hql = "from Customer"; // Customer 代表的是类

        // 调用 session.createQuery 创建查询对象
        Query query = session.createQuery(hql);

        // 使用 query.list() 方法查询数据，并将数据放入一个 list 集合
        List<Customer> list = query.list();

        for (Customer customer : list) {
            System.out.println(customer);
        }

        // 提交事务
        transaction.commit();

        session.close();
        sessionFactory.close();
    }

}
