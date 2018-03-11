package com.ikook.ioc;

public class UserServiceImpl implements UserService {

    // 使用 UserDao 接口声明一个对象
    private UserDao userDao;

    // 添加 UserDao 对象的 set 方法，用于依赖注入
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
        public void addUser() {
        this.userDao.save();
        System.out.println("spring : hello user Service");
    }
}
