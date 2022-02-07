package com.fangpeng.design.pattern.builder.demo1;

/**
 * MobileBuilder
 * @author 方鹏
 * @date 2022年02月07日 5:25 下午
 */
public class MobileBuilder extends Builder {
    @Override
    public void buildFrame() {
        bike.setFrame("碳纤维车架");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("真皮车座");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
