package com.fangpeng.spring.framework.context;

import com.fangpeng.spring.framework.beans.factory.BeanFactory;

/**
 * @Description: TODO
 * @Author : Lemon-CS
 * @Date : 2022年02月10日 6:14 下午
 */
public interface ApplicationContext extends BeanFactory {

    void refresh() throws Exception;

}
