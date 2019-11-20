package com.personal.aspect;
import org.springframework.stereotype.Component;

@Component("deptAspect")
public class DeptAspect {
    public void test1() {
        System.out.println("test1方法");
    }

    public void test2() {
        System.out.println("test2方法");
    }
}
