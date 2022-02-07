package com.fangpeng.design.pattern.decorator;

/**
 * 炒饭(具体构件角色)
 * @author 方鹏
 * @date 2022年02月07日 9:26 下午
 */
public class FriedRice extends FastFood {

    public FriedRice() {
        super(10,"炒饭");
    }

    @Override
    public float cost() {
        return getPrice();
    }
}
