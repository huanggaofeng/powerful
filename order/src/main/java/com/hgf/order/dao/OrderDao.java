package com.hgf.order.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hgf.order.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * created by hgf
 * created time is 2020/3/29
 */
@Mapper
@Repository
public interface OrderDao extends BaseMapper<Orders> {
}
