package com.lemon.dao;

import com.lemon.pojo.User;

import java.util.List;

/**
 * @Description: IUserDao
 * @Author : Lemon-CS
 * @Date : 2022年02月12日 5:03 下午
 */
public interface IUserDao {

    //查询所有用户
    public List<User> findAll() throws Exception;


    //根据条件进行用户查询
    public User findByCondition(User user) throws Exception;

}
