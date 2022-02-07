package com.fangpeng.design.pattern.decorator;

/** 装饰者类(抽象装饰者角色)
 * @author 方鹏
 * @date 2022年02月07日 9:29 下午
 */
public abstract class Garnish extends FastFood {

    //声明快餐类的变量
    private FastFood fastFood;

    public FastFood getFastFood() {
        return fastFood;
    }

    public void setFastFood(FastFood fastFood) {
        this.fastFood = fastFood;
    }

    public Garnish(FastFood fastFood, float price, String desc) {
        super(price, desc);
        this.fastFood = fastFood;
    }

}
