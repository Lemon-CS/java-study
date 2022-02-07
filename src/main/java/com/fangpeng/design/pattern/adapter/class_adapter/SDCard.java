package com.fangpeng.design.pattern.adapter.class_adapter;

/*
 * 目标接口
 * @author 方鹏
 * @date 2022/2/7 8:43 下午
 */
public interface SDCard {

    //从SD卡中读取数据
    String readSD();
    //往SD卡中写数据
    void writeSD(String msg);

}
