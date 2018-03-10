package com.ikook.test;

import com.ikook.domain.Customer;
import com.ikook.utils.HibernateUtils;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

public class HQLTest {

    /**
     * Query按条件查询（只返回一个值）
     */
    @Test
    public void uniqueResult_hqlTest() {

        Session session = HibernateUtils.getSession();
        Transaction t = session.beginTransaction();

        // 2.编写HQL语句,并调用session.createQuery 创建查询对象
        Query query = session.createQuery("from Customer where id =:id"); // Customer代表的是类

        // 3.调用Query的setInteger()方法设置参数
        query.setInteger("id", 3);

        // 4.调用Query对象的uniqueResult()方法执行查询
        Customer c = (Customer) query.uniqueResult();//结果只返回一个值可以使用uniqurResult();
        System.out.println(c);

        t.commit();
        session.close();
    }

    /**
     * 指定别名
     */
    @Test
    public void aliasTest() {

        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        // 编写 HQL
        String hql = "from Customer as c where c.name = 'Jack'";

        // 创建Query对象
        Query query = session.createQuery(hql);

        // 执行查询，获得结果
        List<Customer> cs = query.list();

        //遍历查询结果
        for (Customer c : cs) {
            System.out.println(c);
        }

        transaction.commit();

        session.close();

    }

    /**
     * 部分检索(投影查询)
     */
    @Test
    public void portionQueryTest() {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        // HQL
        String hql = "select c.name, c.age from Customer as c";

        Query query = session.createQuery(hql);

        List<Object[]> list = query.list();
        Iterator iterator = list.iterator();

        while (iterator.hasNext()) {
            Object[] obj = (Object[]) iterator.next();
            System.out.println(obj[0] + "  " + obj[1]);
        }

        transaction.commit();

        session.close();
    }

    /**
     * 部分检索(动态实例查询)
     */
    @Test
    public void dynamicQueryTest() {

        Session session = HibernateUtils.getSession();
        Transaction t = session.beginTransaction();

        // 编写HQL
        String hql = "select new Customer (c.name,c.age) from Customer as c ";

        // 创建Query对象
        Query query = session.createQuery(hql);

        // 执行查询，获得结果
        List<Customer> cs = query.list();

        for (Customer c : cs) {
            System.out.println(c.getName() + " " + c.getAge());
        }

        t.commit();
        session.close();
    }

    /**
     * Query按条件查询
     * 按参数位置
     */
    @Test
    public void paramQueryTest1() {

        Session session = HibernateUtils.getSession();
        Transaction t = session.beginTransaction();

        // 编写HQL，使用参数查询
        String hql = "from Customer where name like ?";

        // 创建Query对象
        Query query = session.createQuery(hql);

        // 为HQL中的"?"代表的参数设置值
        query.setString(0, "%jo%");
//        query.setParameter(0, "%jo%");

        // 执行查询，获得结果
        List<Customer> cs = query.list();
        for (Customer c : cs) {
            System.out.println(c);
        }

        t.commit();
        session.close();
    }

    /**
     * Query按条件查询
     * 按参数名字
     */
    @Test
    public void paramQueryTest2() {

        Session session = HibernateUtils.getSession();
        Transaction t = session.beginTransaction();

        // 编写HQL
        String hql = "from Customer where name=:name";

        // 创建Query对象
        Query query = session.createQuery(hql);

        //添加参数
        query.setParameter("name", "join");

        // 执行查询，获得结果
        List<Customer> cs = query.list();
        for (Customer c : cs) {
            System.out.println(c);
        }

        t.commit();
        session.close();
    }

    /**
     * Query分页查询
     */
    @Test
    public void queryPageTest() {

        // 得到一个Session
        Session session = HibernateUtils.getSession();
        Transaction t = session.beginTransaction();

        // 编写HQL
        String hql = "from Customer";

        // 创建Query对象
        Query query = session.createQuery(hql);

        // 执行查询，获得结果
        query.setFirstResult(2); // 从第几条开始查询
        query.setMaxResults(3); // 查询几条

        List<Customer> cs = query.list();
        for (Customer c : cs) {
            System.out.println(c);
        }

        t.commit();
        session.close();
    }

    /**
     * 分组查询
     */
    @Test
    public void groupQueryTest() {

        Session session = HibernateUtils.getSession();
        Transaction t = session.beginTransaction();

        // 编写HQL，统计不同城市的客户人数
        String hql = "select c.city,count(*) from Customer c group by c.city ";

        // 创建Query对象
        Query query = session.createQuery(hql);

        // 执行查询，获得结果
        List<Customer> cs = query.list();
        Iterator iter = cs.iterator();

        while(iter.hasNext()){
            //每条记录封装成一个Object数组
            Object[] obj  = (Object[]) iter.next();
            System.out.println("所在城市："+obj[0]+"，客户人数： "+obj[1]);
        }

        t.commit();
        session.close();
    }

}
