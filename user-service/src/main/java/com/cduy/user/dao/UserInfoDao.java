package com.cduy.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cduy.user.entity.UserInfo;
import org.springframework.stereotype.Repository;

/**
 * 用户信息
 * @author CDUY
 * @version 1.0
 */
@Repository
public interface UserInfoDao extends BaseMapper<UserInfo> {
}
