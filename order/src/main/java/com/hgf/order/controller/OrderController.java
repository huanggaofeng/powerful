package com.hgf.order.controller;

import com.hgf.order.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * created by hgf
 * created time is 2020/3/29
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/placeOrder")
    public String placeOrder(@RequestParam BigDecimal money) {
        orderService.placeOrder(1, "hgf-----hgf", money);
        return "SUCCESS";
    }
}
