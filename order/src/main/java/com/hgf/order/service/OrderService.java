package com.hgf.order.service;

import com.hgf.order.dao.OrderDao;
import com.hgf.order.entity.Orders;
import com.hgf.order.feign.UserFeignClient;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * created by hgf
 * created time is 2020/3/29
 */
@Service
public class OrderService {

    @Resource
    private UserFeignClient userFeignClient;
    @Resource
    private OrderDao orderDao;

    @GlobalTransactional(rollbackFor = Exception.class)
    public void placeOrder(Integer userId, String commodityCode, BigDecimal orderMoney) {
        Orders order = new Orders(userId, commodityCode, orderMoney);
        // 保存订单记录
        orderDao.insert(order);

        // 通过网关调用用户服务更新账号余额，这里就是个练手的例子
        userFeignClient.updateUserMoney(userId, orderMoney);
    }
}
