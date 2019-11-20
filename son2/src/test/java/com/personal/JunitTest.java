package com.personal;

import com.personal.service.DeptService;
import com.personal.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class JunitTest {
    @Autowired
    private UserService userService;

    @Autowired
    private DeptService deptService;

    @Test
    public void test1() {
//        userService.saveUser();
        userService.saveUser_1();
        userService.delUser();
    }

    @Test
    public void test2() {
        //userService.addA();
        //userService.addA("lichi");

        userService.saveUser("王");
    }

    @Test
    public void test3() {
        //userService.addA();
        //userService.addA("lichi");

        deptService.adda();
    }
}
