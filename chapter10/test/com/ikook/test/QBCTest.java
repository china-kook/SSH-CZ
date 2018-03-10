package com.ikook.test;

import com.ikook.domain.Customer;
import com.ikook.utils.HibernateUtils;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import java.util.List;

public class QBCTest {

    // qbc 查询全部
    @Test
    public void qbcBaseTest() {

        Session session = HibernateUtils.getSession();
        Transaction t = session.beginTransaction();

        Criteria criteria = session.createCriteria(Customer.class);
        List<Customer> cs = criteria.list();
        for (Customer c : cs) {
            System.out.println(c);
        }

        t.commit();
        session.close();
    }


    // 只返回一个值
    @Test
    public void qbcUniqueTest() {

        Session session = HibernateUtils.getSession();
        Transaction t = session.beginTransaction();

        Criteria criteria = session.createCriteria(Customer.class);

        criteria.add(Restrictions.and(Restrictions.eq("city", "beijing"),
                Restrictions.eq("name", "Jack")));

        Customer c = (Customer) criteria.uniqueResult();
        System.out.println(c);

        t.commit();
        session.close();
    }

    /**
     * 组合查询
     * 查询 id=1 or name="joy" 的对象
     */
    @Test
    public void qbcTest1() {
        Session session = HibernateUtils.getSession();
        Transaction t = session.beginTransaction();

        //创建criteria对象
        Criteria criteria = session.createCriteria(Customer.class);

        //设定查询条件
        Criterion criterion = Restrictions.or(Restrictions.eq("id", 1),
                Restrictions.eq("name", "joy"));

        //添加查询条件
        criteria.add(criterion);

        //执行查询,返回查询结果
        List<Customer> cs = criteria.list();
        for (Customer c : cs) {
            System.out.println(c);
        }

        t.commit();
        session.close();
    }


    // 分页
    @Test
    public void qbcTest2() {

        Session session = HibernateUtils.getSession();
        Transaction t = session.beginTransaction();

        //创建criteria对象
        Criteria criteria = session.createCriteria(Customer.class);

        //从第1个对象开始查询（默认第1个对象序号为0）
        criteria.setFirstResult(0);

        //每次冲查询结果中返回3个对象
        criteria.setMaxResults(3);

        //执行查询,返回查询结果
        List<Customer> cs = criteria.list();
        for (Customer c : cs) {
            System.out.println(c);
        }

        t.commit();
        session.close();
    }

    /**
     * 条件查询
     * 查询id为1的对象
     */
    @Test
    public void qbcTest3() {

        Session session = HibernateUtils.getSession();
        Transaction t = session.beginTransaction();

        //创建criteria对象
        Criteria criteria = session.createCriteria(Customer.class);

        //设定查询条件
        Criterion criterion = Restrictions.eq("id", 1);

        //添加查询条件
        criteria.add(criterion);

        //执行查询,返回查询结果
        List<Customer> cs = criteria.list();
        for (Customer c : cs) {
            System.out.println(c);
        }
//        Customer customer = (Customer) criteria.uniqueResult();
//        System.out.println(customer);


        t.commit();
        session.close();
    }



}
