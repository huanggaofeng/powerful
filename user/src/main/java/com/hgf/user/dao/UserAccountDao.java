package com.hgf.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hgf.user.emtity.UserAccount;
import org.apache.ibatis.annotations.Mapper;

/**
 * created by hgf
 * created time is 2020/3/29
 */
@Mapper
public interface UserAccountDao extends BaseMapper<UserAccount> {
}
