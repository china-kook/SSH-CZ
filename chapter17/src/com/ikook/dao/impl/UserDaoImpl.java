package com.ikook.dao.impl;

/**
 * 使用hibernate.cfg.xml
 * <p>
 * 不使用hibernate.cfg.xml
 * <p>
 * 使用注解方式
 * <p>
 * 不使用hibernate.cfg.xml
 * <p>
 * 使用注解方式
 */
//import com.ikook.dao.UserDao;
//import com.ikook.domain.User;
//
//import org.springframework.orm.hibernate3.HibernateTemplate;
//
//import java.util.List;
//
//public class UserDaoImpl implements UserDao {
//    // 提供 hibernate 模板
//    private HibernateTemplate hibernateTemplate;
//
//    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
//        this.hibernateTemplate = hibernateTemplate;
//    }
//
//    public User findById(Integer id) {
//        return this.hibernateTemplate.get(User.class, id);
//    }
//
//    public List<User> findAll() {
//        return this.hibernateTemplate.find("from User");
//    }
//
//    public void save(User user) {
//        this.hibernateTemplate.save(user);
//    }
//
//    public void update(User user) {
//        this.hibernateTemplate.update(user);
//    }
//
//    public void delete(User user) {
//        this.hibernateTemplate.delete(user);
//    }
//}

/**
 * 不使用hibernate.cfg.xml
 */
//import com.ikook.dao.UserDao;
//import com.ikook.domain.User;
//
//import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
//
//import java.util.List;
//
////继承 HibernateDaoSupport 自动生成模板, 必须提供 SessionFactory
//public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
//
//    public User findById(Integer id) {
//        return this.getHibernateTemplate().get(User.class, id);
//    }
//
//    public List<User> findAll() {
//        return this.getHibernateTemplate().find("from User");
//    }
//
//    public void save(User user) {
//        this.getHibernateTemplate().save(user);
//    }
//
//    public void update(User user) {
//        this.getHibernateTemplate().update(user);
//    }
//
//    public void delete(User user) {
//        this.getHibernateTemplate().delete(user);
//    }
//}


/**
 * 使用注解方式
 */

import com.ikook.dao.UserDao;
import com.ikook.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    // 提供hibernate模板
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public User findById(Integer id) {
        return this.hibernateTemplate.get(User.class, id);
    }

    public List<User> findAll() {
        return this.hibernateTemplate.find("from User");
    }

    public void save(User user) {
        this.hibernateTemplate.save(user);
    }

    public void update(User user) {
        this.hibernateTemplate.update(user);
    }

    public void delete(User user) {
        this.hibernateTemplate.delete(user);
    }
}
