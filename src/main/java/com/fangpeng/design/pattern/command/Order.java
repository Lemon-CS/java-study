package com.fangpeng.design.pattern.command;

import java.util.HashMap;
import java.util.Map;

/**
 * 订单类
 * @author 方鹏
 * @date 2022年02月08日 4:02 下午
 */
public class Order {
    //餐桌号码
    private int diningTable;

    //所下的餐品及份数
    private Map<String, Integer> foodDir = new HashMap<>();

    public int getDiningTable() {
        return diningTable;
    }

    public void setDiningTable(int diningTable) {
        this.diningTable = diningTable;
    }

    public Map<String, Integer> getFoodDir() {
        return foodDir;
    }

    public void setFood(String name, int num) {
        foodDir.put(name,num);
    }
}
