package com.hgf.order.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;

/**
 * created by hgf
 * created time is 2020/3/29
 */
@TableName("orders")
public class Orders {
    private Integer id;
    private Integer userId;
    private String commodityCode;
    private BigDecimal money;

    public Orders() {
    }

    public Orders(Integer userId, String commodityCode, BigDecimal money) {
        this.userId = userId;
        this.commodityCode = commodityCode;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", commodityCode='" + commodityCode + '\'' +
                ", money=" + money +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }


    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
