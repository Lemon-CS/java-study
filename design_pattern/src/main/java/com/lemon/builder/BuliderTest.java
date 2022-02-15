package com.lemon.builder;

/**
 * @Description: TODO
 * @Author : Lemon-CS
 * @Date : 2022年02月15日 1:43 下午
 */
public class BuliderTest {

    public static void main(String[] args) {
        ComputerBuilder computerBuilder = new ComputerBuilder();
        computerBuilder.installDisplayer("显示器");
        computerBuilder.installMainUnit("主机");
        computerBuilder.installmouse("鼠标");
        computerBuilder.installkeyboard("键盘");

        Computer computer = computerBuilder.getComputer();
        System.out.println(computer);
    }

}
