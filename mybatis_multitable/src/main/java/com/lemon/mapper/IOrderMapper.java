package com.lemon.mapper;

import com.lemon.pojo.Order;
import com.lemon.pojo.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description: TODO
 * @Author : Lemon-CS
 * @Date : 2022年02月13日 2:37 下午
 */
public interface IOrderMapper {

    //查询订单以及订单所属的用户信息
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "orderTime", column = "ordertime"),
            @Result(property = "total", column = "total"),
            @Result(property = "user", column = "uid", javaType = User.class,
                    one = @One(select = "com.lemon.mapper.IUserMapper.findUserById")),
    })
    @Select("select * from orders")
    public List<Order> findOrderAndUser();

}
