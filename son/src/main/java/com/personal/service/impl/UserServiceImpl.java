package com.personal.service.impl;

import com.personal.dao.UserDao;
import com.personal.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private String gender;

    public UserServiceImpl(UserDao userDao,String gender) {
        super();
        this.userDao = userDao;
        this.gender = gender;
    }

    public UserServiceImpl() {
        super();
    }

    @Override
    public void login(String username, String password) {
        userDao.login(username, password);
    }

    @Override
    public void save() {
        userDao.add();
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setUserDao(UserDao userDao) {

        this.userDao = userDao;
    }
}
