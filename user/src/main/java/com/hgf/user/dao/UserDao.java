package com.hgf.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hgf.user.emtity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * created by hgf
 * created time is 2020/2/19
 */
@Mapper
public interface UserDao extends BaseMapper<User> {

    String getUserNameById(Integer id);

    User selectById(Integer Id);
}
