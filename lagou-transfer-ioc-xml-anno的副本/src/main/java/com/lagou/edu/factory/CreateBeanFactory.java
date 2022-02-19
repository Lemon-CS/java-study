package com.lagou.edu.factory;

import com.lagou.edu.utils.ConnectionUtils;

/**
 * @author Lemon-CS
 */
public class CreateBeanFactory {



    public static ConnectionUtils getInstanceStatic() {
        return new ConnectionUtils();
    }


    public ConnectionUtils getInstance() {
        return new ConnectionUtils();
    }
}
