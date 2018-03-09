package com.ikook.test;

import com.ikook.entity.Book;
import com.ikook.utils.HibernateUtils;

import org.hibernate.Session;
import org.junit.Test;

public class BookTest {

    // 演示持久化对象的三种状态

    @Test
    public void test1() {
        // 1. 得到 session 对象
        Session session = HibernateUtils.getSession();

        // 2. 开启事务
        session.beginTransaction();

        // 3. 操作
        Book book = new Book(); // 瞬时态
        book.setName("Java 编程思想");
        book.setPrice(100d);

        session.save(book);  // 持久化状态

        // 4.提交事务
        session.getTransaction().commit();

        // 5.关闭资源
        session.close();
        System.out.println(book); // 脱管(游离)
    }

    // 证明一级缓存的存在
    @Test
    public void test2() {
        // 1. 得到 session 对象
        Session session = HibernateUtils.getSession();

        // 2. 开启事务
        session.beginTransaction();

        // 3.操作
        // 获取 b1 对象时，由于一级缓存中没有数据，所以会发送 sql 语句查询数据库
        Book b1 = (Book) session.get(Book.class, 1);
        System.out.println(b1);

        // 获取b2对象时，会从 session 的缓存中获取数据
        Book b2 = (Book) session.get(Book.class, 1);
        System.out.println(b2);

        // 4.提交事务
        session.getTransaction().commit();

        // 5.关闭资源
        session.close();
    }

    //  hibernate 快照
    @Test
    public void test3() {

        // 1.得到session
        Session session = HibernateUtils.getSession();

        // 2.开启事务
        session.beginTransaction();

        // 3.操作
        Book book = new Book(); // 瞬时
        book.setName("精通 struts");
        book.setPrice(65d);

        session.save(book); // 持久化状态 一级缓存中存在 book.

        book.setName("精通 hibernate");

        // 4.提交事务
        session.getTransaction().commit();

        // 5.关闭资源
        session.close();

    }

    // 一级缓存常见操作-刷出
    @Test
    public void test4() {
        // 1.得到session
        Session session = HibernateUtils.getSession();

        // 2.开启事务
        session.beginTransaction();

        // 3.操作
        Book book = (Book) session.get(Book.class, 2);
        book.setName("Java Web");
        session.flush(); // 会发送 update 语句.

        // 4.提交事务
        session.getTransaction().commit();

        // 5.关闭资源
        session.close();
    }

    // 一级缓存常见操作-清除
    @Test
    public void test5() {
        // 1.得到session
        Session session = HibernateUtils.getSession();

        // 2.开启事务
        session.beginTransaction();

        // 3.操作
        Book book = (Book) session.get(Book.class, 2); // 获取book对象

        System.out.println(book);// 输出book对象

        book.setName("JavaSE");// 修改book对象的name属性值
        session.clear(); // 清空一级缓存

        // 4.提交事务
        session.getTransaction().commit();

        // 5.关闭资源
        session.close();
    }

    // 一级缓存常见操作-刷新
    @Test
    public void test6() {
        // 1.得到session
        Session session = HibernateUtils.getSession();

        // 2.开启事务
        session.beginTransaction();

        // 3.操作
        Book book = (Book) session.get(Book.class, 2); // 持久状态 在一级缓存中存在
        book.setName("精通Struts");
        session.refresh(book); // 查询数据库，恢复快照和一级缓存中的数据

        // 4.提交事务
        session.getTransaction().commit();
        // 5.关闭资源
        session.close();
    }

}
