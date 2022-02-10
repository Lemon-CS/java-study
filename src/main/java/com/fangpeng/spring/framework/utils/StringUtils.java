package com.fangpeng.spring.framework.utils;

/**
 * @Description: TODO
 * @Author : Lemon-CS
 * @Date : 2022年02月10日 6:44 下午
 */
public class StringUtils {

    private StringUtils() {

    }

    // userDao   ==>   setUserDao
    public static String getSetterMethodByFieldName(String fieldName) {
        String methodName = "set" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
        return methodName;
    }

}
