package com.fangpeng.design.principles.demo4.after;

public class Client {

    public static void main(String[] args) {
        //创建黑马安全门对象
        MySafetyDoor door = new MySafetyDoor();
        //调用功能
        door.antiTheft();
        door.fireproof();
        door.waterproof();

        System.out.println("============");
        //创建传智安全门对象
        CustomSafetyDoor door1 = new CustomSafetyDoor();
        //调用功能
        door1.antiTheft();
        door1.fireproof();
    }

}
