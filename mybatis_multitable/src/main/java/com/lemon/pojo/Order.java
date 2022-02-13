package com.lemon.pojo;

/**
 * @Description: Order
 * @Author : Lemon-CS
 * @Date : 2022年02月13日 2:26 下午
 */
public class Order {

    private Integer id;
    private String orderTime;
    private Double total;

    // 表明该订单属于哪个用户
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderTime='" + orderTime + '\'' +
                ", total=" + total +
                ", user=" + user +
                '}';
    }
}
