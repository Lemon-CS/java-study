package com.fangpeng.design.pattern.adapter.class_adapter;

/**
 * 适配者类
 * @author 方鹏
 * @date 2022年02月07日 8:45 下午
 */
public class TFCardImpl implements TFCard {
    @Override
    public String readTF() {
        String msg = "TFCard read msg ： hello word TFcard";
        return msg;
    }

    @Override
    public void writeTF(String msg) {
        System.out.println("TFCard write msg :" + msg);
    }
}
