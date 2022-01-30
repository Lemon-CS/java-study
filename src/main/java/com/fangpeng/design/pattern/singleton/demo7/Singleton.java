package com.fangpeng.design.pattern.singleton.demo7;

/*
    静态内部类方式
 */
public class Singleton {

    //私有构造方法
    private Singleton() {}

    //定义一个静态内部类
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    //提供公共的访问方式
    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    //当进行反序列化时，会自动调用该方法，将该方法的返回值直接返回
    public Object readResolve() {
        return SingletonHolder.INSTANCE;
    }

}
