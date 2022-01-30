package com.fangpeng.design.pattern.factory.factory_method;

public class Client {

    public static void main(String[] args) {
        //1,创建咖啡店类
        CoffeeStore store = new CoffeeStore();
        store.setFactory(new AmericanCoffeeFactory());
        //2,点咖啡
        Coffee coffee = store.orderCoffee();

        System.out.println(coffee.getName());
    }

}
