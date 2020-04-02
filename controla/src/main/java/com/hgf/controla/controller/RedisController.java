package com.hgf.controla.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by hgf
 * created time is 2019/11/25
 */
@RestController
public class RedisController {



    @GetMapping("/fallBack")
    public String fallBack() {
        return "前方正忙，请稍后重试";
    }

    @GetMapping("/userFallBack")
    public String userFallBackGet() {
        return "用户前方正忙，请稍后重试";
    }

    @PostMapping("/userFallBack")
    public String userFallBackPost() {
        return "用户前方正忙，请稍后重试";
    }
}
