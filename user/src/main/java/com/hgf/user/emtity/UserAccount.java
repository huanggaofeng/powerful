package com.hgf.user.emtity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;

/**
 * created by hgf
 * created time is 2020/3/29
 */
@TableName("user_account")
public class UserAccount {
    private Integer id;
    private Integer userId;
    private BigDecimal money;

    public UserAccount() {
    }

    public UserAccount(Integer userId, Integer id, BigDecimal money) {
        this.userId = userId;
        this.id = id;
        this.money = money;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
