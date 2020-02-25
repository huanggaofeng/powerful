package com.hgf.controla.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by hgf
 * created time is 2019/11/25
 */
@RestController
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/rediss")
    public String rediss() {
        redisTemplate.opsForValue().set("qqqq", "qwe");
        return "hgf";
    }

    @GetMapping("/fallBack")
    public String fallBack() {
        return "前方正忙，请稍后重试";
    }

    @GetMapping("/userFallBack")
    public String userFallBack() {
        return "用户前方正忙，请稍后重试";
    }
}
