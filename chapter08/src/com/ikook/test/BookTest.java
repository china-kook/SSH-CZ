package com.ikook.test;

import com.ikook.entity.Book;
import com.ikook.utils.HibernateUtils;

import org.hibernate.Session;
import org.junit.Test;

public class BookTest {

    // 演示持久化对象的三种状态

    @Test
    public void test1(){
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

}
