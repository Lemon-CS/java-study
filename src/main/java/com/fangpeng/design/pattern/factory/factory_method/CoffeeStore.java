package com.fangpeng.design.pattern.factory.factory_method;

import com.fangpeng.design.pattern.factory.simple_factory.SimpleCoffeeFactory;

public class CoffeeStore {

    private CoffeeFactory factory;

    public void setFactory(CoffeeFactory factory) {
        this.factory = factory;
    }

    public Coffee orderCoffee() {

        Coffee coffee = factory.createCoffee();

        //加配料
        coffee.addMilk();
        coffee.addSugar();

        return coffee;
    }

}
