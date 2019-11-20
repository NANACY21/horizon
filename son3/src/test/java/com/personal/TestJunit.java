package com.personal;




import com.personal.mapper.ItemsMapper;
import com.personal.pojo.Items;
import com.personal.service.ItemsService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-dao.xml", "classpath:applicationContext-transaction.xml"})

public class TestJunit {
    @Autowired
    private DataSource ds;
    @Autowired
    private SqlSessionFactory factory;
    @Autowired
    private ItemsMapper itemsMapper;
    @Autowired
    private ItemsService itemsService;
    @Test
    public void test1() throws SQLException {
        //ok
        //System.out.println("nancy能获取连接" + ds.getConnection());
        //ok
        //System.out.println("nancy能..." + factory.openSession());
        //ok
        //List<Items> allItem = itemsMapper.getAllItem();
        //ok
        //List<Items> allItem = itemsService.getAllItem();
    }
}
