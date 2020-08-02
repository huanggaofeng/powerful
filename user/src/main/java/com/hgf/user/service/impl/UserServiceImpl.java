package com.hgf.user.service.impl;

import cn.hutool.db.nosql.redis.RedisDS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hgf.user.dao.UserDao;
import com.hgf.user.emtity.User;
import com.hgf.user.service.UserService;
import com.hgf.user.utils.RedisUtils;
import org.springframework.aop.framework.AopContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
    public User getUserById(Integer id) {
        User u = this.baseMapper.selectById(id);
        return u;
    }

    /**
     * 测试spring事务，不开启事务
     */
    @Override
    public void insertUserNoTra() {
        User u = new User("hgf2", 11);
        this.save(u);
    }

    /**
     * 测试spring事务，开启事务
     */
    @Override
    @Transactional()
    public void insertUserTra() {
        User u = new User("hgf3", 12);
        this.save(u);
        try {
            int a = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    @Transactional
    public void updateUser(Integer id, String name) {
        User u = this.baseMapper.selectById(id);
        u.setUserName(name);
        this.updateById(u);
    }

    @Override
    @Transactional
    public void updateAge(Integer age) {
        Jedis jedis = RedisDS.create().getJedis();
        while (!RedisUtils.tryGetDistributedLock(jedis, "userid1", "userid1", 3)) {
            // System.out.println("尝试获取锁");
        }
        User user = this.baseMapper.selectById(1);
        user.setAge(user.getAge() + 1);
        this.updateById(user);
        RedisUtils.releaseDistributedLock(jedis, "userid1", "userid1");
    }

}
