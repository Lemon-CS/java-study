package com.fangpeng.spring.framework.beans.factory;

/**
 * @Description: IOC容器父接口
 * @Author : Lemon-CS
 * @Date : 2022年02月10日 6:14 下午
 */
public interface BeanFactory {

    Object getBean(String name) throws Exception;

    <T> T getBean(String name, Class<? extends T> clazz) throws Exception;

}
