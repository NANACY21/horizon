package com.personal.dao.impl;
import com.personal.dao.UserDao;
import com.personal.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public int addUser(User user) {
        SqlSession session = factory.openSession();
        int insert = session.insert("test.addUser", user);
        session.commit();
        session.close();
        return insert;
    }

    @Override
    public int delUser(long uID) {
        SqlSession session = factory.openSession();
        int delete = session.delete("test.delUser", uID);
        session.commit();
        session.close();
        return delete;
    }

    @Override
    public int updateUser(User user) {
        SqlSession session = factory.openSession();
        int update = session.update("test.updateUser", user);
        session.commit();
        session.close();
        return update;
    }

    @Override
    public User getUserByUID(long uID) {
        SqlSession session = factory.openSession();
        User user = session.selectOne("test.selectUserByUID", uID);
        session.commit();
        session.close();
        return user;
    }

    @Override
    public List<User> getAllUser() {
        SqlSession session = factory.openSession();
        List<User> allUser = session.selectList("test.getAllUser");
        session.commit();
        session.close();
        return allUser;
    }
}
