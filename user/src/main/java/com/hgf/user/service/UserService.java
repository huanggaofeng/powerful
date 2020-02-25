package com.hgf.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hgf.user.emtity.User;

/**
 * created by hgf
 * created time is 2019/12/9
 */
public interface UserService extends IService<User> {

    String getUserNameById(Integer id);

    User getUserById(Integer id);

    void insertUserNoTra();

    void insertUserTra();

    void updateUser(Integer id);


}
