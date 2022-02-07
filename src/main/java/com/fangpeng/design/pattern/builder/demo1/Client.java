package com.fangpeng.design.pattern.builder.demo1;


/**
 * @author 方鹏
 * @date 2022年02月07日 5:30 下午
 */
public class Client {

    public static void main(String[] args) {
        //创建指挥者对象
        Director director = new Director(new MobileBuilder());

        //让指挥者只会组装自行车
        Bike bike = director.construct();

        System.out.println(bike.getFrame());
        System.out.println(bike.getSeat());
    }

}
