package com.fangpeng.design.pattern.adapter.class_adapter;

/**
 * 具体的SD卡
 * @author 方鹏
 * @date 2022年02月07日 8:47 下午
 */
public class SDCardImpl implements SDCard {

    public String readSD() {
        String msg = "SDCard read msg ： hello word SD";
        return msg;
    }

    public void writeSD(String msg) {
        System.out.println("SDCard write msg ：" + msg);
    }
}
