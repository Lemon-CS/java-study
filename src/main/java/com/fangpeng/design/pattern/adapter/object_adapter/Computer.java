package com.fangpeng.design.pattern.adapter.object_adapter;

/**
 * 计算机类
 * @author 方鹏
 * @date 2022年02月07日 8:42 下午
 */
public class Computer {

    //从SD卡中读取数据
    public String readSD(SDCard sdCard) {
        if(sdCard == null) {
            throw new NullPointerException("sd card is null");
        }
        return sdCard.readSD();
    }

}
