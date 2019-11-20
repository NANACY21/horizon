package com.personal.dao;

import com.personal.pojo.NUser;

import java.util.List;
public interface NUserDao {
    public int addNUser(String nickname, String password);

    public int delNUserByUID(long uID);

    public int updateNUser(long uID, String newNickname, String newPassword);
    public NUser getNUserByUID(long uID);

    public List<NUser> getAllNUser();
}
