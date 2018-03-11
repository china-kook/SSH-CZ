package com.ikook.dao;

import com.ikook.domain.User;

import java.util.List;

public interface UserDao {

    public void save(User user);

    public void update(User user);

    public void delete(User user);

    public User findById(Integer id);

    public List<User> findAll();
}
