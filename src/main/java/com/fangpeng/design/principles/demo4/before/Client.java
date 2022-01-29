package com.fangpeng.design.principles.demo4.before;

public class Client {
    public static void main(String[] args) {
        MySafetyDoor door = new MySafetyDoor();
        door.antiTheft();
        door.fireProof();
        door.waterProof();
    }
}
