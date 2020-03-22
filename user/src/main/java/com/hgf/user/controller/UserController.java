package com.hgf.user.controller;

import com.hgf.user.dto.UserDto;
import com.hgf.user.service.UserService;
import com.hgf.user.utils.JwtUtil;
import com.hgf.user.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

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

    @RequestMapping("/updateName")
    public R updateName(@RequestBody UserDto userDto) {
        userService.updateUser(userDto.getId(), userDto.getName());

        return R.ok();
    }

    @RequestMapping("/login")
    public R login() {
        String token = JwtUtil.createJWT(UUID.randomUUID().toString(), "hgf", 60 * 1000L);
        redisTemplate.opsForValue().set("hgf", token);
        redisTemplate.expire("hgf", 60, TimeUnit.SECONDS);
        return R.ok().put("token", token);
    }
}
