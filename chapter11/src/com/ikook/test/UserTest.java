package com.ikook.test;

import com.ikook.domain.User;
import com.ikook.utils.HibernateUtils;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class UserTest {

    @Test
    public void test1() {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        User user = (User) session.get(User.class, 1);
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getAge());

        transaction.commit();
        session.close();
    }

    @Test
    public void test2() {

        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        //        User user = (User) session.get(User.class, 1, LockMode.UPGRADE); // 悲观锁
        User user = (User) session.get(User.class, 1);
        user.setUsername("ikook");

        session.save(user);

        transaction.commit();
        session.close();

    }

    @Test
    public void test3() {

        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

//        User user = (User) session.get(User.class, 1, LockMode.UPGRADE); // 悲观锁
        User user = (User) session.get(User.class, 1);
        user.setAge(50);

        session.save(user);

        transaction.commit();
        session.close();

    }

}
