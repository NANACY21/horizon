package com.personal.dao;
import com.personal.pojo.User;
import java.util.List;

public interface UserDao {
    public int addUser(User user);
    public int delUser(long uID);

    public int updateUser(User user);
    public User getUserByUID(long uID);

    public List<User> getAllUser();
}
