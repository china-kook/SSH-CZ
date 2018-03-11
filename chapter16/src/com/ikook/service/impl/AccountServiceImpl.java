package com.ikook.service.impl;

import com.ikook.dao.AccountDao;
import com.ikook.service.AccountService;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//采用注解方式
@Transactional(propagation = Propagation.REQUIRED,
        isolation = Isolation.DEFAULT, readOnly = false)
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String outUser, String inUser, int money) {
        this.accountDao.out(outUser, money);
        // 模拟断电
        int i = 1/0;
        this.accountDao.in(inUser, money);
    }
}