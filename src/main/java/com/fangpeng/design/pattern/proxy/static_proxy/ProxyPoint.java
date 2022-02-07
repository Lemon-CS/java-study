package com.fangpeng.design.pattern.proxy.static_proxy;

/**
 * 代售点类
 * @author 方鹏
 * @date 2022年02月07日 6:12 下午
 */
public class ProxyPoint implements SellTickets {

    //声明火车站类对象
    private TrainStation trainStation = new TrainStation();

    @Override
    public void sell() {
        System.out.println("代售点收取一些服务费用");
        trainStation.sell();
    }
}
