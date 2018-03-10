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

}
