package com.personal.cglib;//cglib动态代理示例

public class Test {
    public static void main(String[] args) {
        UserService service = new UserService();
        CGLIBProxy proxy = new CGLIBProxy();
        UserService proxy1 = (UserService) proxy.createProxy(service);
        proxy1.add();

    }

}
