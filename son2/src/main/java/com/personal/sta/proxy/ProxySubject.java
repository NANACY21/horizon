package com.personal.sta.proxy;

/**
 * 静态代理类
 * 缺点：要为每一个目标类生成一个代理类吗？
 */
public class ProxySubject implements Subject {


    //代理这个类
    private RealSubject real = new RealSubject();
    @Override
    public void save() {
        System.out.println("6");
        real.save();
        System.out.println("456");

    }

    @Override
    public void delete() {
        real.delete();

    }
}
