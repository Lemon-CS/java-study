package com.fangpeng.design.pattern.factory.abstract_factory;

/*
    美式风味的甜品工厂:生产美式咖啡和抹茶慕斯
 */
public class AmericanDessertFactory implements DessertFactory {
    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }

    @Override
    public Dessert createDessert() {
        return new MatchaMousse();
    }
}
