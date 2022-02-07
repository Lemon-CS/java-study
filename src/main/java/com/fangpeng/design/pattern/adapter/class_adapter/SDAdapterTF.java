package com.fangpeng.design.pattern.adapter.class_adapter;

/**
 * 适配器类
 * @author 方鹏
 * @date 2022年02月07日 8:47 下午
 */
public class SDAdapterTF extends TFCardImpl implements SDCard {
    @Override
    public String readSD() {
        System.out.println("adapter read tf card");
        return readTF();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("adapter write tf card");
        writeTF(msg);
    }
}
