package com.personal.dynamic;//jdk动态代理示例

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK的动态代理
 * 设计模式：动态代理
 * 适用于有接口的目标类
 *
 * 好处：为所有目标类生成对象，解决了静态代理的弊端
 */
public class JDKProxy implements InvocationHandler {

    //代理这个类
    private Object targetObject;

    public Object createProxy(Object targetObject) {
        this.targetObject = targetObject;
        return Proxy.newProxyInstance(this.targetObject.getClass().getClassLoader(), this.targetObject.getClass().getInterfaces(), this);

    }

    /**
     * 好处：为所有目标类生成对象
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().startsWith("save")) {
            System.out.println("123before");
        }

        Object invoke = method.invoke(targetObject, args);
        if (method.getName().startsWith("save")) {
            System.out.println("after");
        }
        return invoke;
    }
}
