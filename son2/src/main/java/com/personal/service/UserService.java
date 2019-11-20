package com.personal.service;

import com.personal.pojo.NUser;

public interface UserService {
    public void saveUser();
    public void saveUser(String info);
    public int saveNUser(String nickname,String password);

    public NUser getNUser(long uID);
    public void saveUser_1();
    public void delUser();

    public void addA();

    public void addA(String username);

    public void addA(String username, String password);



}
