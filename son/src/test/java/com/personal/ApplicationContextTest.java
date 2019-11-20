package com.personal;

import com.personal.demo.TestCollection;
import com.personal.service.DeptService;
import com.personal.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ApplicationContextTest {

    //单纯的junit
    @Test
    public void test1() {
        //参数文件位置必须固定
        //ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        //参数文件位置可以不固定
        ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/resources/applicationContext.xml");
        UserService userService = ctx.getBean("userService", UserService.class);
        userService.save();


        // STOPSHIP: 2019/8/15
        TestCollection bean = ctx.getBean(TestCollection.class);
        bean.list();
        bean.set();
        bean.map();
        bean.prop();
    }

    @Test
    public void test2() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //DeptDao bean = ctx.getBean(DeptDao.class);
        //bean.add();
        DeptService bean1 = ctx.getBean(DeptService.class);
        bean1.save();
    }
}
