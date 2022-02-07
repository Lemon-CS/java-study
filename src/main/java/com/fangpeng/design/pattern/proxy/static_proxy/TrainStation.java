package com.fangpeng.design.pattern.proxy.static_proxy;

/**
 * 火车站类
 * @author 方鹏
 * @date 2022年02月07日 6:11 下午
 */
public class TrainStation implements SellTickets {

    public void sell() {
        System.out.println("火车站卖票");
    }
}
