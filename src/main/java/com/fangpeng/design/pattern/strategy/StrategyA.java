package com.fangpeng.design.pattern.strategy;

/**
 * 具体策略类，封装算法
 * @author 方鹏
 * @date 2022年02月08日 3:38 下午
 */
public class StrategyA implements Strategy {

    @Override
    public void show() {
        System.out.println("买一送一");
    }
}
