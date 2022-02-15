package com.lemon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lemon.pojo.User;

import java.util.List;

/**
 * @Description: TODO
 * @Author : Lemon-CS
 * @Date : 2022年02月15日 6:22 下午
 */
public interface UserMapper extends BaseMapper<User> {

    /*  查询所有用户  */
    public List<User> findAll();


    /*  添加用户  */
    public int insert(User user);

}
