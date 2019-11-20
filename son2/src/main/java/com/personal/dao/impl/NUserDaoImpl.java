package com.personal.dao.impl;

import com.personal.dao.NUserDao;
import com.personal.pojo.NUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class NUserDaoImpl implements NUserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addNUser(String nickname, String password) {
        String sql = "insert into nuser(nickname,password) values (?,?)";
        return jdbcTemplate.update(sql, new Object[]{nickname, password});
    }

    @Override
    public int delNUserByUID(long uID) {
        return jdbcTemplate.update("delete from nuser where uID=?",uID);
    }

    @Override
    public int updateNUser(long uID, String newNickname, String newPassword) {
        return jdbcTemplate.update("update nuser set nickname=?,password=? where uID=?",new Object[]{"NANCY","123456",10});

    }

    @Override
    public NUser getNUserByUID(long uID) {

        String sql = "select * from nuser where uID=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{uID}, new RowMapper<NUser>() {

            //该方法数据表一行执行一次
            @Override
            public NUser mapRow(ResultSet resultSet, int i) throws SQLException {
                NUser nUser = new NUser();
                nUser.setuID(resultSet.getLong("uID"));
                nUser.setNickname(resultSet.getString("nickname"));
                nUser.setPassword(resultSet.getString("password"));
                return nUser;
            }
        });
//        return null;
    }

    @Override
    public List<NUser> getAllNUser() {
        String sql = "select * from nuser";
        return jdbcTemplate.query(sql, new RowMapper<NUser>() {
            @Override
            public NUser mapRow(ResultSet resultSet, int i) throws SQLException {
                NUser nUser = new NUser();
                nUser.setuID(resultSet.getLong("uID"));
                nUser.setNickname(resultSet.getString("nickname"));
                nUser.setPassword(resultSet.getString("password"));
                return nUser;
            }
        });
    }
}
