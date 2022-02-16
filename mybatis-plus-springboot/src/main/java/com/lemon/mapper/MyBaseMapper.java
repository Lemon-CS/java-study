package com.lemon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lemon.pojo.User;

import java.util.List;

/*
    通用mapper接口，以后创建其他mapper接口时，不再继承BaseMapper，而是继承MyBaseMapper
 */
public interface MyBaseMapper<T> extends BaseMapper<T> {

    /*
            查询所有用户
    */
    public List<User> findAll();

}
