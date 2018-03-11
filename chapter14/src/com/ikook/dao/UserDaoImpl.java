package com.ikook.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public void save() {
        System.out.println("save 添加用户");
    }

    @Override
    public void update() {
        System.out.println("update 修改用户");
    }

    @Override
    public void delete() {
        System.out.println("delete 删除用户");
    }

    @Override
    public void find() {
        System.out.println("find 查询用户");
    }


}
