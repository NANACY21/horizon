package com.personal.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;

public class CGLIBProxy implements MethodInterceptor {
    private Object targetObject;//目标类

    public Object createProxy(Object targetObject) {
        this.targetObject = targetObject;
        Enhancer enhancer = new Enhancer();//这是代理类，它的父类是目标类，它因此重写父类的东西，从而达到插入代码的效果
        enhancer.setSuperclass(targetObject.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before..");

        Object invoke = methodProxy.invoke(targetObject, objects);

        System.out.println("after..");
        return invoke;
    }
}
