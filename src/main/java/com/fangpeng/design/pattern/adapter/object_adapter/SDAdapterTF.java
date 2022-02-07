package com.fangpeng.design.pattern.adapter.object_adapter;

/**
 * 适配器类
 * @author 方鹏
 * @date 2022年02月07日 8:47 下午
 */
public class SDAdapterTF implements SDCard {

    //声明适配者类
    private TFCard tfCard;

    public SDAdapterTF(TFCard tfCard) {
        this.tfCard = tfCard;
    }

    @Override
    public String readSD() {
        System.out.println("adapter read tf card");
        return tfCard.readTF();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("adapter write tf card");
        tfCard.writeTF(msg);
    }
}
