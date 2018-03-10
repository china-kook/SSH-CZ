package com.ikook.onetomany;

import com.ikook.utils.HibernateUtils;

import org.hibernate.Session;
import org.junit.Test;

public class OneToManyTest {

    // 添加数据
    @Test
    public void test1() {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();

        // 创建一个客户
        Customer customer = new Customer();
        customer.setName("张三");

        // 创建两个订单
        Order order1 = new Order();
        order1.setAddress("北京");
        order1.setPrice(10000d);

        Order order2 = new Order();
        order2.setAddress("上海");
        order2.setPrice(5000d);

        // 描述关系 —— 订单属于某个客户
        order1.setCustomer(customer);
        order2.setCustomer(customer);

        // 描述关系 —— 客户拥有多个订单
//        customer.getOrders().add(order1);
//        customer.getOrders().add(order2);

        // 先存客户再存订单
        session.save(customer);
        session.save(order1);
        session.save(order2);

        session.beginTransaction().commit();
        session.close();
    }

    // 级联保存。保存客户和订单，客户关联订单,仅保存客户 -- 抛异常，持久态对象 关联 瞬时态对象
    @Test
    public void test2() {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();

        //1 客户
        Customer customer = new Customer();
        customer.setName("李四");

        //2 订单
        Order order = new Order();
        order.setAddress("上海");
        order.setPrice(2000d);

        //3 客户关联订单
        customer.getOrders().add(order);

        //4 仅保存客户
        session.save(customer);        //insert

        session.getTransaction().commit();    //update

        session.close();
    }

    // 默认情况下，删除客户时，订单的 cid 为null.
    @Test
    public void test3() {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();

        // 查询 id=2 的用户
        Customer c = (Customer) session.get(Customer.class, 4);
        session.delete(c);

        session.getTransaction().commit();
        session.close();
    }

    // 级联删除
    @Test
    public void test4() {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();

        // 查询 id=3 的用户，删除该用户的同时删除其关联的订单
        Customer c = (Customer) session.get(Customer.class,3);
        session.delete(c);//删除该客户对象

        session.getTransaction().commit();
        session.close();
    }

    // 孤儿删除，需要解除父子关系
    @Test
    public void test5(){
        Session session = HibernateUtils.getSession();
        session.beginTransaction();

        // 1.查询客户
        Customer customer = (Customer) session.get(Customer.class, 6);

        // 2.查询订单
        Order order = (Order) session.get(Order.class,6);

        // 3.解除关系
        customer.getOrders().remove(order);

        session.getTransaction().commit();
        session.close();
    }

}
