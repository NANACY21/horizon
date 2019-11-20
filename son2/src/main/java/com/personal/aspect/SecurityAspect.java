package com.personal.aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 在这里写非功能性代码，插入的方法
 */
@Component
//@Aspect//表示这是一个切面
public class SecurityAspect {
    /**在这里，切点和通知是在一起定义的
     * 前置通知
     * 参数是指定方法，在其前加入通知
     *
     * execution表达式，切点表达式
     */
    @Before("execution(* save*(..))")
    public void testSecurity() {
        System.out.println("test...");
    }
}
