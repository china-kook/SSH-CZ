package com.ikook.test;

import com.ikook.domain.User;
import com.ikook.utils.HibernateUtils;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class SecondEHChcheTest {

    @Test
    public void testCache() {
        Session session1 = HibernateUtils.getSession();
        Transaction tx1 = session1.beginTransaction();

        User user1 = (User) session1.get(User.class, 1);//user1 会在一级缓存中存在，也会在二级缓存中存在
        User user2 = (User) session1.get(User.class, 1);// 因为 session 没有关闭，这时会从一级缓存中取出数据

        System.out.println(user1 == user2);// 代表 user1,user2 都是从一级缓存中获取到的.

        tx1.commit();
        session1.close();// sesison1 关闭，一级缓存被清理


        Session session2 = HibernateUtils.getSession();
        Transaction tx2 = session2.beginTransaction();

        /**
         * 查询时控制台没有打印 sql 语句，此时 user3 是从二级缓存中获取的，
         * 取出后，二级缓存会与一级缓存做一个同步，会将 user3 又在一级缓存中存在了
         */
        User user3 = (User) session2.get(User.class, 1);
        System.out.println(user1 == user3); //false 是因为 user3 是从二级缓存中获取的，二级缓存中存放的是散装数据，它们会重新 new 出一个对象

        User user4 = (User) session2.get(User.class, 1);//从一级缓存中获取
        System.out.println(user3 == user4);

        tx2.commit();
        session2.close();
    }

}
