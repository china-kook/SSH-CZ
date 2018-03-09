package com.ikook.test;

import com.ikook.domain.Customer;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import java.util.List;

public class CriteriaTest {

    @Test
    public void qbcTest() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // 通过 session 获取 Criteria 对象
        Criteria criteria = session.createCriteria(Customer.class);

        // 执行 Criteria 的 list() 获得结果
        List<Customer> list = criteria.list();

        for (Customer customer : list) {
            System.out.println(customer);
        }

        transaction.commit();

        session.close();
        sessionFactory.close();
    }

    @Test
    public void qbcTest2() {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // 通过 session 获取 Criteria 对象
        Criteria criteria = session.createCriteria(Customer.class);

        // 使用 Restrictions 的 eq 方法设定查询条件为 sex="男"
        // 向 Criteria 对象中添加 查询条件
        criteria.add(Restrictions.eq("sex", "男"));

        // 执行 Criteria 的 list() 获得结果
        List<Customer> list = criteria.list();

        for (Customer customer : list) {
            System.out.println(customer);
        }

        transaction.commit();

        session.close();
        sessionFactory.close();
    }

}
