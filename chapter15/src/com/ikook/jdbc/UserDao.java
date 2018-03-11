package com.ikook.jdbc;

import java.util.List;

public interface UserDao {

    //添加用户
    public int addUser(User user);

    //更新用户
    public int updateUser(User user);

    //删除用户
    public int deleteUserById(int id);

    //根据 id 查询
    public User findUserById(int id);

    //查询所有用户
    public List<User> findAllUser();
}
