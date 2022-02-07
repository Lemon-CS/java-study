package com.fangpeng.design.pattern.decorator;

/**
 * 鸡蛋类(具体的装饰者角色)
 * @author 方鹏
 * @date 2022年02月07日 9:30 下午
 */
public class Egg extends Garnish {

    public Egg(FastFood fastFood) {
        super(fastFood, 1, "鸡蛋");
    }

    @Override
    public float cost() {
        //计算价格
        return getPrice() + getFastFood().cost();
    }

    @Override
    public String getDesc() {
        return super.getDesc() + getFastFood().getDesc();
    }
}
