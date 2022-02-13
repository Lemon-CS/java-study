package com.lemon.mapper;

import com.lemon.pojo.Order;
import com.lemon.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Description: TODO
 * @Author : Lemon-CS
 * @Date : 2022年02月13日 2:30 下午
 */
public interface IUserMapper {

    //查询所有用户、同时查询每个用户关联的订单信息
    public List<User> findAll();

    //查询所有用户、同时查询每个用户关联的角色信息
    public List<User> findAllUserAndRole();

    //添加用户
    @Insert("insert into user values(#{id}, #{username}, #{password}, #{birthday})")
    public void addUser(User user);

    //更新用户
    @Update("update user set username = #{username} where id = #{id}")
    public void updateUser(User user);

    //查询用户
    @Select("select * from user")
    public List<User> selectUser();

    //删除用户
    @Delete("delete from user where id = #{id}")
    public void deleteUser(Integer id);

    //根据id查询用户
    @Select({"select * from user where id = #{id}"})
    public User findUserById(Integer id);

}
