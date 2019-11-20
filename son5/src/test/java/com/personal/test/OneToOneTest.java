package com.personal.test;

import com.personal.dao.RolesDao;
import com.personal.dao.UserzDao;
import com.personal.pojo.Roles;
import com.personal.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-dao.xml"})
public class OneToOneTest {
    @Autowired
    private UserzDao userzDao;
    @Autowired
    private RolesDao rolesDao;
    @Test
    public void test1() {
        List<User> userAge = userzDao.getUserAge(22);
        for (User user : userAge) {

            //如果设置延迟加载，第一次方法之后session就关了  要指定session的延迟关闭
//            System.out.println(user.getUsername() + "\t" + user.getRoles().getRolename());
            System.out.println(user.getUsername());//延迟加载关联对象
        }
    }

    @Test
    public void test2() {
        Roles roles = rolesDao.findById(2).get();
        System.out.println(roles.getRolename());
        Set<User> users = roles.getUsers();
        System.out.println(users.size());
        for (User user : users) {
            System.out.println(user.getUsername());
        }
    }
}
