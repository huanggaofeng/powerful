package com.hgf.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hgf.user.dao.UserDao;
import com.hgf.user.emtity.User;
import com.hgf.user.service.UserService;
import org.springframework.aop.framework.AopContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * created by hgf
 * created time is 2019/12/9
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Override
    public String getUserNameById(Integer id) {
        return this.baseMapper.getUserNameById(id);
    }

    @Override
    @Async
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public User getUserById(Integer id) {
        User u = this.getById(id);
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        User u2 = this.baseMapper.selectById(id);
        return u2;
    }

    /**
     * 测试spring事务，不开启事务
     */
    @Override
    public void insertUserNoTra() {
        User u = new User("hgf2", 11);
        this.save(u);
        insertUserTra();
        int a = 1 / 0;
    }

    /**
     * 测试spring事务，开启事务
     */
    @Override
    @Transactional()
    public void insertUserTra() {
        User u = new User("hgf3", 12);
        this.save(u);
        int a = 1 / 0;
    }

    @Override
    @Transactional()
    public void updateUser(Integer id, String name) {
        User u = this.baseMapper.selectById(id);
        u.setUserName(name);
        this.updateById(u);
    }

}
