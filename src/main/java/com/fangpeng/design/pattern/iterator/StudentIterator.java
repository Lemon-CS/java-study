package com.fangpeng.design.pattern.iterator;

/*
 * 抽象迭代器角色接口
 * @author 方鹏
 * @date 2022/2/8 8:49 下午
*/
public interface StudentIterator {

    //判断是否还有元素
    boolean hasNext();

    //获取下一个元素
    Student next();

}
