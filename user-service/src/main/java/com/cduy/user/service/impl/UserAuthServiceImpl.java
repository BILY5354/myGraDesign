package com.cduy.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cduy.user.dao.UserAuthDao;
import com.cduy.user.domain.UserAuth;
import com.cduy.user.service.UserAuthService;
import org.springframework.stereotype.Service;

/**
 * @author CDUY
 * @version 1.0
 */
@Service
public class UserAuthServiceImpl extends ServiceImpl<UserAuthDao, UserAuth> implements UserAuthService {
}
