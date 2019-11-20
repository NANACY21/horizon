package com.personal.sta.proxy;//该包示例了静态代理模式（23种设计模式之一）

/**
 *
 */
public class Test {
    public static void main(String[] args) {
        Subject subject = new ProxySubject();//扩展了目标类的行为
        subject.save();
    }
}
