package com.lemon.pojo;

/**
 * @Description: TODO
 * @Author : Lemon-CS
 * @Date : 2022年02月11日 11:26 下午
 */
public class User {

    private Integer id;
    private String username;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }

}
