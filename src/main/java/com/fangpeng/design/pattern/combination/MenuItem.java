package com.fangpeng.design.pattern.combination;

/**
 * 菜单项类 ： 属于叶子节点
 * @author 方鹏
 * @date 2022年02月08日 2:12 下午
 */
public class MenuItem extends MenuComponent {

    public MenuItem(String name,int level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void print() {
        //打印菜单项的名称
        for(int i = 0; i < level; i++) {
            System.out.print("--|");
        }
        System.out.println(name);
    }

}
