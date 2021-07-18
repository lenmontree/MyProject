package controller;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InvocationHandlerImpl implements InvocationHandler {

    private Object target;

    public InvocationHandlerImpl(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("中介带着看房子！");
        String s = "".trim();
        s.getBytes();
        String replaceAll = s.replaceAll("\\W", "").toUpperCase();
        method.invoke(target, args);
        System.out.println("签合同，中介收中介费");
        return null;
    }

    public Object getProxy(){
        // 通过反射机制，创建一个代理类对象并返回实例，用户进行方法调用时使用
        // 创建代理对象时，需要传递该业务类的类加载器（用来获取业务实现类的元数据，调用真的的业务方法）、接口、handler实现类(this是当前对象)
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
}
