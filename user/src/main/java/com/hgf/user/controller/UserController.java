package com.hgf.user.controller;

import cn.hutool.db.nosql.redis.RedisDS;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hgf.user.dto.UserDto;
import com.hgf.user.emtity.User;
import com.hgf.user.emtity.UserAccount;
import com.hgf.user.service.UserAccountService;
import com.hgf.user.service.UserService;
import com.hgf.user.utils.JwtUtil;
import com.hgf.user.utils.R;
import com.hgf.user.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * created by hgf
 * created time is 2019/11/14
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private Jedis jedis = RedisDS.create().getJedis();

    @Autowired
    private UserService userService;
    @Autowired
    private UserAccountService userAccountService;

    @RequestMapping("/getName")
    public String getName(Integer id) {

        return userService.getUserNameById(id);
    }

    @RequestMapping("/rediss")
    public String rediss() {
        jedis.set("qqqq", "444");
        return "hgf";
    }

    @GetMapping("/getLock")
    public String getLock() {
        boolean flag = RedisUtils.tryGetDistributedLock(jedis, "hgf", "hgf", 20);
        if (flag) {
            return "success";
        }
        return "error";
    }

    @GetMapping("/unLock")
    public String unLock() {
        boolean flag = RedisUtils.releaseDistributedLock(jedis, "hgf", "hgf");
        if (flag) {
            return "success";
        }
        return "error";
    }

    @RequestMapping("/updateName")
    public R updateName(@RequestBody UserDto userDto) {
        userService.updateUser(userDto.getId(), userDto.getName());

        return R.ok();
    }

    @RequestMapping("/login")
    public R login() {
        String token = JwtUtil.createJWT(UUID.randomUUID().toString(), "hgf", 60 * 1000L);
        //redisTemplate.opsForValue().set("hgf", token);
        // redisTemplate.expire("hgf", 60, TimeUnit.SECONDS);
        return R.ok().put("token", token);
    }

    @PostMapping("/updateUserMoney")
    public String updateUserMoney(@RequestParam Integer userId, @RequestParam BigDecimal money) {
        UserAccount userAccount = new UserAccount(userId, 1, money);
        try {
            Thread.sleep(5000);
            userAccountService.updateById(userAccount);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //int i = 1/0;
        return "SUCCESS";
    }

    @GetMapping("/getNow")
    public String getNow() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis());
        return "SUCCESS";
    }

    @PostMapping("/updateAge")
    public String updateAge(Integer age) {
        userService.updateAge(age);
        return "SUCCESS";
    }
}
