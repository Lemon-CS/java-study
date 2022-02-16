package com.lemon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lemon.pojo.User;

import java.util.List;

/**
 * @Description: TODO
 * @Author : Lemon-CS
 * @Date : 2022年02月15日 6:22 下午
 */
public interface UserMapper extends MyBaseMapper<User> {

    /*
        自定义findById方法
     */
    public User findById(Long id);

}
