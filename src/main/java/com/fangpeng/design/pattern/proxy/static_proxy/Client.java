package com.fangpeng.design.pattern.proxy.static_proxy;

/**
 * @author 方鹏
 * @date 2022年02月07日 6:14 下午
 */
public class Client {

    public static void main(String[] args) {
        //创建代售点类对象
        ProxyPoint proxyPoint = new ProxyPoint();
        //调用方法进行买票
        proxyPoint.sell();
    }

}
