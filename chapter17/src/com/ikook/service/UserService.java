package com.ikook.service;

import com.ikook.domain.User;

import java.util.List;

public interface UserService {

    public void saveUser(User user);

    public void updateUser(User user);

    public void deleteUser(User user);

    public User findUserById(Integer id);

    public List<User> findAllUser();
}
