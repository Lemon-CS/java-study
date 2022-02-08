package com.fangpeng.design.pattern.strategy;

/**
 * 促销员(环境类)
 * @author 方鹏
 * @date 2022年02月08日 3:40 下午
 */
public class SalesMan {

    //聚合策略类对象
    private Strategy strategy;

    public SalesMan(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    //由促销员展示促销活动给用户
    public void salesManShow() {
        strategy.show();
    }

}
