package com.fangpeng.design.pattern.builder.demo1;

/**
 * Builder
 * @author 方鹏
 * @date 2022年02月07日 5:24 下午
 */
public abstract class Builder {

    //声明Bike类型的变量，并进行赋值
    protected Bike bike = new Bike();

    public abstract void buildFrame();

    public abstract void buildSeat();

    //构建自行车的方法
    public abstract Bike createBike();

}
