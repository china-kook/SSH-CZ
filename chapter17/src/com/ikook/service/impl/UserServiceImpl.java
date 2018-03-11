package com.ikook.service.impl;

/**
 * 不使用注解
 * <p>
 * 使用注解的方式
 */

//import com.ikook.dao.UserDao;
//import com.ikook.domain.User;
//import com.ikook.service.UserService;
//
//import java.util.List;
//
//public class UserServiceImpl implements UserService {
//
//    private UserDao userDao;
//
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }
//
//    public void saveUser(User user) {
//        this.userDao.save(user);
//    }
//
//    public void updateUser(User user) {
//        this.userDao.update(user);
//    }
//
//    public void deleteUser(User user) {
//        this.userDao.delete(user);
//    }
//
//    public User findUserById(Integer id) {
//        return this.userDao.findById(id);
//    }
//
//    public List<User> findAllUser() {
//        return this.userDao.findAll();
//    }
//}


/**
 * 使用注解的方式
 */
import com.ikook.dao.UserDao;
import com.ikook.domain.User;
import com.ikook.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void saveUser(User user) {
        this.userDao.save(user);
    }

    @Transactional
    public void updateUser(User user) {
        this.userDao.update(user);
    }

    @Transactional
    public void deleteUser(User user) {
        this.userDao.delete(user);
    }

    @Transactional(readOnly = true)
    public User findUserById(Integer id) {
        return this.userDao.findById(id);
    }

    @Transactional(readOnly = true)
    public List<User> findAllUser() {
        return this.userDao.findAll();
    }
}
