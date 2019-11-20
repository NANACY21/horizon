package com.personal;

import com.personal.dao.NUserDao;
import com.personal.pojo.NUser;
import com.personal.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class DBCPTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private NUserDao dao;
    @Autowired
    private UserService service;
    @Test
    public void test1() {
        try {
            System.out.println(dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testAddNUser() {
        dao.addNUser("NANCY", "123");

    }

    @Test
    public void testGetNUser() {
        NUser nUserByUID = dao.getNUserByUID(10);
        System.out.println(nUserByUID);
        List<NUser> allNUser = dao.getAllNUser();
        for (NUser user : allNUser) {
            System.out.println(user);
        }
    }


    /**
     * 事务处理测试
     */
    @Test
    public void testTransaction() {
        service.saveNUser("aaa", "456");
    }
}
