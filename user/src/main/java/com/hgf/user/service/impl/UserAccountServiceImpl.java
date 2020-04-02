package com.hgf.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hgf.user.dao.UserAccountDao;
import com.hgf.user.emtity.UserAccount;
import com.hgf.user.service.UserAccountService;
import org.springframework.stereotype.Service;

/**
 * created by hgf
 * created time is 2020/3/29
 */
@Service
public class UserAccountServiceImpl extends ServiceImpl<UserAccountDao, UserAccount> implements UserAccountService {

}
