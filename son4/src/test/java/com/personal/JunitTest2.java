package com.personal;


import com.personal.dao.UserDao;
import com.personal.dao.impl.UserDaoImpl;
import com.personal.mapper.OrdersMapper;
import com.personal.mapper.T_userMapper;
import com.personal.mapper.UserMapper;
import com.personal.pojo.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * 关联查询示例
 */
public class JunitTest2 {
    /*构建session工厂，类似连接
    管理session
     */
    SqlSessionFactory sqlSessionFactory = null;
    InputStream is = null;
    @Before
    public void before() {
        try {
            is = Resources.getResourceAsStream("SqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*整个应用创建一次就可以
        右边是匿名对象，没有引用，不需要*/
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    }
    @Test
    public void test1() {
        SqlSession session = sqlSessionFactory.openSession();
        OrdersMapper mapper = session.getMapper(OrdersMapper.class);
        List<Orders> ordersAndT_users = mapper.getOrdersAndT_users();

        for (Orders order : ordersAndT_users) {
            System.out.println(order);
        }
        session.commit();
        session.close();
    }

    /**
     * mybatis一级缓存示例
     */
    @Test
    public void test2() {
        SqlSession session = sqlSessionFactory.openSession();
        OrdersMapper mapper = session.getMapper(OrdersMapper.class);
        T_userMapper mapper1 = session.getMapper(T_userMapper.class);



        Orders orders = mapper.getOrdersAndDetailsByID(1);
        //session.flushStatements();session.commit();//禁止session的缓存



        T_user user = new T_user();
        user.setID(new Long(7));
        user.setADDRESS("南方");
        user.setUSERNAME("2019.08.23");
        user.setBIRTHDAY(new Date());
        user.setSEX("f");
        mapper1.addT_user(user);//dml操作->缓存会自动清空，不然会脏读

        Orders orders2 = mapper.getOrdersAndDetailsByID(1);

        session.commit();
        session.close();
    }
    @Test
    public void test3() {
        SqlSession session = sqlSessionFactory.openSession();
        T_userMapper mapper = session.getMapper(T_userMapper.class);
        List<T_user> t_usersAndItems = mapper.getT_usersAndItems();
        for (T_user user : t_usersAndItems) {
            System.out.println(user.getUSERNAME());
            List<Orders> userOrders = user.getOrders();
            for (Orders ords : userOrders) {
                List<Orderdetail> Orderdetail = ords.getOrderDetail();
                for (Orderdetail od : Orderdetail) {
                    Items items = od.getItems();
                    System.out.println("-->:" + items.getName());
                }
            }
        }
        session.commit();
        session.close();
    }

    @Test
    public void test4() {
        SqlSession session = sqlSessionFactory.openSession();
        T_userMapper mapper = session.getMapper(T_userMapper.class);
        //参数：起始索引 个数
        List<T_user> t_userPage = mapper.getT_userPage(new RowBounds(0, 2));
        for (T_user user : t_userPage) {
            System.out.println(user);
        }
        session.commit();
        session.close();
    }

    /**
     * 延迟加载示例
     */
    @Test
    public void test5() {
        SqlSession session = sqlSessionFactory.openSession();
        OrdersMapper mapper = session.getMapper(OrdersMapper.class);
        List<Orders> orders = mapper.selectLazyOrders();


        for (Orders o : orders) {
            //System.out.println(o.getID());//这会不加载t_user
            System.out.println(o.getT_user());//这会加载t_user
        }
        session.commit();
        session.close();
    }

    /**
     * mybatis二级缓存示例
     * @throws IOException
     */
    @Test
    public void test6() throws IOException {
        SqlSession session = sqlSessionFactory.openSession();
        OrdersMapper ordersMapper = session.getMapper(OrdersMapper.class);
        Orders orders = ordersMapper.getOrdersAndDetailsByID(1);


        //不可能是一级缓存，因为session已关闭
        session.close();
        SqlSession session1 = sqlSessionFactory.openSession();
        OrdersMapper ordersMapper1 = session1.getMapper(OrdersMapper.class);
        Orders ordersAndDetailsByID = ordersMapper1.getOrdersAndDetailsByID(1);
        session1.commit();
        session1.close();
    }

    //传统开发方式
    @Test
    public void UserDaoTest() {
        UserDao dao = new UserDaoImpl(sqlSessionFactory);
        User user = new User();
        user.setNickname("大连");
        user.setPassword("1230");
        int i = dao.addUser(user);

    }

    //mapper代理开发方式
    @Test
    public void mapperTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.delUser(19);
        sqlSession.commit();
        sqlSession.close();
    }

    //mapper代理开发方式
    @Test
    public void mapperTest2() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        //user.setNickname("NANCY");
        //user.setPassword("123");
        List<User> users = mapper.selectUserByNicknameAndPassword(user);

        for (User u:users) {
            System.out.println(u);
        }
        sqlSession.commit();
        sqlSession.close();
    }



    //mapper代理开发方式
    @Test
    public void mapperTest3() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Long> uIDs = new ArrayList<>();
        uIDs.add(Long.parseLong("9"));
        uIDs.add(Long.parseLong("10"));
        uIDs.add(Long.parseLong("11"));
        List<User> users = mapper.selectUsersByUIDs(uIDs);

        for (User u:users) {
            System.out.println(u);
        }

        long[] ss = {14, 15, 16, 17, 18};
        Map<String, Object> maps = new HashMap<>();
//        like '%${name}%'
        maps.put("name", "功夫");
//        collection="uIDs"
        maps.put("uIDs", ss);
        System.out.println("----------");
        List<User> users1 = mapper.selectUsersByMap(maps);
        for (User uu : users1) {
            System.out.println(uu);
        }

        User user = mapper.selectUserByUID(9);
        System.out.println(user+"lalallala");
        sqlSession.commit();
        sqlSession.close();
    }

}
