package com.fangpeng.design.pattern.template;

/**
 * @author 方鹏
 * @date 2022年02月08日 3:11 下午
 */
public class Client {

    public static void main(String[] args) {
        //炒包菜
        //创建对象
        ConcreteClass_BaoCai baoCai = new ConcreteClass_BaoCai();
        //调用炒菜的功能
        baoCai.cookProcess();
    }

}
