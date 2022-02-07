package com.fangpeng.design.pattern.decorator;

/**
 * @author 方鹏
 * @date 2022年02月07日 9:27 下午
 */
public class FriedNoodles extends FastFood {

    public FriedNoodles() {
        super(12,"炒面");
    }

    @Override
    public float cost() {
        return getPrice();
    }
}
