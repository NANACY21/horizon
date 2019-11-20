package com.personal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    public static void main(String[] args) {
        Person p = new Person();
        p.setAxe(new StoneAxe());
        p.useAxe();

        //获取spring上下文，获取spring控制权
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        //参数是bean id
        Person person = (Person) ac.getBean("person");
        Person person1 = (Person) ac.getBean("person");
        System.out.println(person == person1);//生成单例，可以改成多例

        person.useAxe();
    }
}
