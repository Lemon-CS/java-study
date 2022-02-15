package com.lemon.dynamicproxy;

/**
 * @Description: TODO
 * @Author : Lemon-CS
 * @Date : 2022年02月15日 2:19 下午
 */
public class proxyTest {

    public static void main(String[] args) {
        System.out.println("不使用代理类，调用doSomething");
        Person person = new Bob();
        person.doSomething();
        System.out.println("--------------------------");

        System.out.println("使用代理类，调用doSomething");

        Person proxy = (Person) new JDKDynamicProxy(new Bob()).getTarget();
        proxy.doSomething();
    }

}
