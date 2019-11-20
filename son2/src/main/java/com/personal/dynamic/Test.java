package com.personal.dynamic;//jdk动态代理示例

import com.personal.sta.proxy.RealSubject;
import com.personal.sta.proxy.Subject;

public class Test {
    public static void main(String[] args) {

        Subject subject = new RealSubject();//目标类

        JDKProxy proxy = new JDKProxy();
        Subject proxy1 = (Subject) proxy.createProxy(subject);
        proxy1.save();
        proxy1.delete();

    }
}
