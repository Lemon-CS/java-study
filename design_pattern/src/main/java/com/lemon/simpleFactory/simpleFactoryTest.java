package com.lemon.simpleFactory;

/**
 * @Description: TODO
 * @Author : Lemon-CS
 * @Date : 2022年02月15日 2:09 下午
 */
public class simpleFactoryTest {

    public static void main(String[] args) {
        Computer computer = ComputerFactory.createComputer("hp");
        computer.start();
    }

}
