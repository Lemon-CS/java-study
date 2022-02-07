package com.fangpeng.design.pattern.builder.demo1;

/**
 * @author 方鹏
 * @date 2022年02月07日 5:28 下午
 */
public class Director {

    //声明builder类型的变量
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    //组装自行车的功能
    public Bike construct() {
        builder.buildFrame();
        builder.buildSeat();
        return builder.createBike();
    }

}
