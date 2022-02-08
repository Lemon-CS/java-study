package com.fangpeng.design.pattern.template;

/**
 * 炒包菜类
 * @author 方鹏
 * @date 2022年02月08日 3:10 下午
 */
public class ConcreteClass_BaoCai extends AbstractClass {

    @Override
    public void pourVegetable() {
        System.out.println("下锅的蔬菜是包菜");
    }

    @Override
    public void pourSauce() {
        System.out.println("下锅的酱料是辣椒");
    }
}
