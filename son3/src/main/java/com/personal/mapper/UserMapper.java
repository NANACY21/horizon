package com.personal.mapper;

import com.personal.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * UserDao
 */
public interface UserMapper {
    public int addUser(User user);
    public int delUser(long uID);

    public int updateUser(User user);
    public User selectUserByUID(long uID);

    public List<User> getAllUser();

    public List<User> selectUserByNicknameAndPassword(User user);

    public List<User> selectUsersByUIDs(List<Long> uIDs);
    public List<User> selectUsersByArrayUIDs(long[] uIDs);

    public List<User> selectUsersByMap(Map<String, Object> maps);
}
