package com.lemon.simpleFactory;

/**
 * @Description: TODO
 * @Author : Lemon-CS
 * @Date : 2022年02月15日 2:07 下午
 */
public class ComputerFactory {

    public static Computer createComputer(String type) {
        Computer computer = null;
        switch (type) {
            case "lenveo":
                computer = new LenovoComputer();
                break;
            case "hp":
                computer = new HpComputer();
                break;
            default:
                System.out.println("没有此品牌电脑");
        }
        return computer;
    }

}
