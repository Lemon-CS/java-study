package com.lemon.builder;

/**
 * @Description: ComputerBuilder-Computer的建造者类
 * @Author : Lemon-CS
 * @Date : 2022年02月15日 1:36 下午
 */
public class ComputerBuilder {

    private Computer computer = new Computer();

    public void installDisplayer(String displayer){
        computer.setDisplayer(displayer);
    }

    public void installMainUnit(String mainUnit){
        computer.setMainUnit(mainUnit);
    }

    public void installmouse(String mouse){
        computer.setMouse(mouse);
    }

    public void installkeyboard(String keyboard){
        computer.setKeyboard(keyboard);
    }

    public Computer getComputer(){
        return computer;
    }

}
