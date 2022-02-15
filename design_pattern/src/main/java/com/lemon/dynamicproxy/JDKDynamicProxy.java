package com.lemon.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description: JDKDynamicProxy
 * @Author : Lemon-CS
 * @Date : 2022年02月15日 2:15 下午
 */
public class JDKDynamicProxy implements InvocationHandler {

    // 声明被代理的对象
    Person target;

    // 构造函数
    public JDKDynamicProxy(Person person) {
        this.target = person;
    }

    // 获取代理对象
    public Object getTarget() {
        Object proxyInstance = Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
        return proxyInstance;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("对原方法进行了前置增强");
        //原方法执行
        Object result = method.invoke(target, args);
        System.out.println("对原方法进行了后置增强");
        return result;
    }
}
