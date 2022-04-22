package com.cduy.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cduy.user.dto.ResourceRoleDTO;
import com.cduy.user.dto.RoleDTO;
import com.cduy.user.entity.Role;
import com.cduy.user.vo.ConditionVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色
 * @author CDUY
 * @version 1.0
 */
@Repository
public interface RoleDao extends BaseMapper<Role> {

    /**
     * 查询路由角色列表
     *
     * @return 角色标签
     */
    List<ResourceRoleDTO> listResourceRoles();

    /**
     * 根据用户id获取角色列表
     *
     * @param userInfoId 用户id
     * @return 角色标签
     */
    List<String> listRolesByUserInfoId(Integer userInfoId);

    /**
     * 查询角色列表
     *
     * @param current 页码
     * @param size 条数
     * @param conditionVO 条件
     * @return 角色列表
     */
    List<RoleDTO> listRoles(@Param("current") Long current, @Param("size") Long size,
                            @Param("conditionVO") ConditionVO conditionVO);

}
