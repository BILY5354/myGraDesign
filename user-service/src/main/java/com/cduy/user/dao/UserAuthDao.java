package com.cduy.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cduy.user.entity.UserAuth;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author CDUY
 * @version 1.0
 */
@Mapper
@Repository
public interface UserAuthDao extends BaseMapper<UserAuth> {
}
