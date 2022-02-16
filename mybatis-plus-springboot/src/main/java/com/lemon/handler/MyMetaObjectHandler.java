package com.lemon.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * @Description: TODO
 * @Author : Lemon-CS
 * @Date : 2022年02月16日 11:59 下午
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        Object version = getFieldValByName("version", metaObject);
        if (version == null) {
            // 该属性为空，可以进行填充
            setFieldValByName("version", 1, metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
