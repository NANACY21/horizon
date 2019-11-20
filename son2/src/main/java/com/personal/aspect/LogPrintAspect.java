package com.personal.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 记录日志：在操作前后需要插入方法以记录操作日志
 */
@Component
@Aspect
public class LogPrintAspect {
    /**
     * 通知方法
     *
     * 该包及其子包下的add开头的方法会插入方法
     */
    @Pointcut("execution(* com.personal.service..add*(..))")
    private void method() { }

    @Pointcut("execution(* com.personal.service..save*(..))")
    private void method1() { }

    @Before("method()")
    public void test1() {
        System.out.println("test666");
    }


    /**
     * 在调用带参数的目标方法之后执行，顺带还获取了目标方法的参数
     * 如果用户是删除了这个数据，但是你在这里获取到了这份数据，就可以备份了，
     * 即使数据库中没了，你还可以再存到另一个地方
     * @param username
     */
    @After("method() && args(username)")//这样的会插入后置方法
    public void test2(String username) {
        System.out.println("after:" + username);
    }

    /**
     * 环绕通知
     * @param pjp
     * @return
     */
    @Around("method1()")
    public Object test3(ProceedingJoinPoint pjp) {
        pjp.getSignature().getName();//获取目标方法的名字
        pjp.getArgs();//得到目标方法的参数值
        System.out.println("方法执行前");
        Object proceed = null;
        try {
            proceed = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("方法执行后");
        return proceed;
    }
}

