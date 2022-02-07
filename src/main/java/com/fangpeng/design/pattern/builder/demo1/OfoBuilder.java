package com.fangpeng.design.pattern.builder.demo1;

/**
 * OfoBuilder
 * @author 方鹏
 * @date 2022年02月07日 5:25 下午
 */
public class OfoBuilder extends Builder {
    @Override
    public void buildFrame() {
        bike.setFrame("铝合金车架");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("橡胶车座");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
