package com.hgf.user.controller;

import com.hgf.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by hgf
 * created time is 2019/11/14
 */
@RestController
public class UserController {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserService userService;

    @RequestMapping("/getName")
    public String getName(Integer id) {

        return userService.getUserNameById(id);
    }

    @RequestMapping("/rediss")
    public String rediss() {
        redisTemplate.opsForValue().set("qqqq", "qwe");
        return "hgf";
    }

    @RequestMapping("/update")
    public String update() {
        userService.getUserById(30);
        userService.updateUser(30);

        return "123";
    }
}
