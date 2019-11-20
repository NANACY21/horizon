package com.personal.dao.impl;

import com.personal.dao.UserDao;

public class UserDaoImpl implements UserDao {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void login(String username, String password) {
        System.out.println(username + "\t" + password);
    }

    @Override
    public void add() {
        System.out.println("add" + name);

    }
}
