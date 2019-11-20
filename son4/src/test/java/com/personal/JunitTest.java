package com.personal;


import com.personal.dao.UserDao;
import com.personal.dao.impl.UserDaoImpl;
import com.personal.mapper.UserMapper;
import com.personal.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class JunitTest {

    /**构建session工厂，类似连接
     * 管理session
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
        //对象：新建、持久化、游离状态
        /*一次会话（从建立连接到关闭连接为一次会话），每次操作都新建一个
        线程不安全的，多个要同步处理*/
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setNickname("辽ss宁");
        user.setPassword("1230");
        System.out.println(user.getuID());
        int insert = sqlSession.insert("test.addUser", user);
        System.out.println(user.getuID());
        System.out.println(insert);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void test2() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User(15, "15555", "1555");
        //参数命名空间.id
        int update = sqlSession.update("test.updateUser", user);


        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void test3() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("test.delUser", 15);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test4() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("test.selectUserByUID", 13);
//        sqlSession.commit();
        sqlSession.close();
        System.out.println(user);
    }

    @Test
    public void test5() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> objects = sqlSession.selectList("test.getAllUser");

        for (User user : objects) {
            System.out.println(user);
        }
        sqlSession.close();
    }
    @Test
    public void test6() throws IOException {
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
        InputStream stream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //环境id
        SqlSessionFactory factory = ssfb.build(stream,"development");//这一次之后stream就关了
        System.out.println(factory);//不同environment地址不一样

    }

    /**
     * 传统开发方式
     */
    @Test
    public void UserDaoTest() {
        UserDao dao = new UserDaoImpl(sqlSessionFactory);
        User user = new User();
        user.setNickname("大连");
        user.setPassword("1230");
        int i = dao.addUser(user);
    }

    /**
     * mapper代理开发方式
     */
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
