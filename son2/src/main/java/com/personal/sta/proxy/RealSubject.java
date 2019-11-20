package com.personal.sta.proxy;

/**
 * 真正的业务类，目标类
 */
public class RealSubject implements Subject {

    @Override
    public void save() {
        System.out.println("功能代码->save()执行...");
    }

    @Override
    public void delete() {
        System.out.println("功能代码->delete()执行...");
    }
}
