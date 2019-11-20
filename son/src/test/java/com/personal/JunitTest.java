package com.personal;

import com.personal.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//这是spring和junit进行整合的标签
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class JunitTest {

    //不用getBean，直接获取对象，不用new、不用从上下文取
    @Autowired
    private UserService userService;//声明
    @Test
    public void test1() {
        userService.login("lichi", "123123");

    }
}
