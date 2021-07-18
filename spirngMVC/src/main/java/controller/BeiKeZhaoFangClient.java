package controller;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class BeiKeZhaoFangClient {

    public static void main(String[] args){

        Host host = new Host("张三");
//        Host host1 = new Host("李四");
        /**1.静态代理*/
//
//        ProxyRent proxyRent = new ProxyRent(host);
//        proxyRent.rent();
//
//        ProxyRent proxyRent1 = new ProxyRent(host1);
//        proxyRent1.rent();

        /**2.动态代理*/
        InvocationHandlerImpl invocationHandler = new InvocationHandlerImpl(host);
//
//        ClassLoader classLoader = host.getClass().getClassLoader();
//        Class<?>[] interfaces = host.getClass().getInterfaces();
//
//        Rent rent = (Rent) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        Rent proxy = (Rent) invocationHandler.getProxy();
        proxy.rent();

    }
}

