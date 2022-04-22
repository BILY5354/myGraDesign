package com.cduy.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cduy.user.dto.UserAreaDTO;
import com.cduy.user.dto.UserBackDTO;
import com.cduy.user.entity.UserAuth;
import com.cduy.user.vo.ConditionVO;
import com.cduy.user.vo.PageResult;
import com.cduy.user.vo.PasswordVO;
import com.cduy.user.vo.UserVO;

import java.util.List;

/**
 * 用户账号服务
 * @author CDUY
 * @version 1.0
 */
public interface UserAuthService extends IService<UserAuth> {
    /**
     * 获取用户区域分布
     *
     * @param conditionVO 条件签证官
     * @return {@link List <UserAreaDTO>} 用户区域分布
     */
    List<UserAreaDTO> listUserAreas(ConditionVO conditionVO);

    /**
     * 用户注册
     *
     * @param user 用户对象
     */
    void register(UserVO user);

    /**
     * 修改密码
     *
     * @param user 用户对象
     */
    void updatePassword(UserVO user);

    /**
     * 修改管理员密码
     *
     * @param passwordVO 密码对象
     */
    void updateAdminPassword(PasswordVO passwordVO);

    /**
     * 查询后台用户列表
     *
     * @param condition 条件
     * @return 用户列表
     */
    PageResult<UserBackDTO> listUserBackDTO(ConditionVO condition);
}
