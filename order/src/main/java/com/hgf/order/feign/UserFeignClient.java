package com.hgf.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * created by hgf
 * created time is 2020/3/29
 */
@FeignClient(name = "controla")
public interface UserFeignClient {

    @PostMapping("/user/user/updateUserMoney")
    String updateUserMoney(@RequestParam Integer userId, @RequestParam BigDecimal money);
}
