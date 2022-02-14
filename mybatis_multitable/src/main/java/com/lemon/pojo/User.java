package com.lemon.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description: TODO
 * @Author : Lemon-CS
 * @Date : 2022年02月13日 2:25 下午
 */
@Table(name = "user")
public class User implements Serializable {

    @Id //对应的是注解id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //设置主键的生成策略
    private int id;
    private String username;
    private String password;
    private Date birthday;

    ////代表当前⽤户具备哪些订单
    //private List<Order> orderList;
    //
    ////表示用户关联的角色
    //private List<Role> roleList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    //public List<Order> getOrderList() {
    //    return orderList;
    //}
    //
    //public void setOrderList(List<Order> orderList) {
    //    this.orderList = orderList;
    //}
    //
    //public List<Role> getRoleList() {
    //    return roleList;
    //}
    //
    //public void setRoleList(List<Role> roleList) {
    //    this.roleList = roleList;
    //}


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
