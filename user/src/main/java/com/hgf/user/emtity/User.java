package com.hgf.user.emtity;


import com.baomidou.mybatisplus.annotation.TableName;

/**
 * created by hgf
 * created time is 2020/2/19
 */
@TableName("user")
public class User {
    private Integer id;
    private String userName;
    private Integer age;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }

    public User() {
    }

    public User(Integer id, Integer age) {
        this.id = id;
        this.age = age;
    }

    public User(String userName, Integer age) {
        this.userName = userName;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
