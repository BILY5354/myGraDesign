package com.cduy.user.controller;

import com.cduy.user.config.PatternProperties;
import com.cduy.user.dto.UserAreaDTO;
import com.cduy.user.dto.UserBackDTO;
import com.cduy.user.entity.UserAuth;
import com.cduy.user.service.UserAuthService;
import com.cduy.user.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * 用户账号控制器
 * @author CDUY
 * @version 1.0
 */
@Api(tags = "用户账号模块")
@RestController
/*@RequestMapping("/users")*/
//@RefreshScope//实现nacos配置热更新 第一种方式，第二种在config.PatternProperties
public class UserAuthController {

    @Autowired
    private UserAuthService userAuthService;

    /*******START 配置热更新*******/
    //第一种 获取配置管理的配置 在nacos上的
    /*@Value("${pattern.dateformat}")
    private String dateformat;*/

    //第二种 使用配置类 config.PatternProperties
    @Autowired
    private PatternProperties properties;

    @GetMapping("/users/now")
    public String now() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(properties.getDateformat()));
    }
    /*******END 配置热更新*******/


    /*******START 多环境配置共享*******/
    @GetMapping("/users/prop")
    public PatternProperties properties() {
        return properties;
    }
    /*******END 多环境配置共享*******/

    /*******START 多环境配置共享*******/
    /**
     * 查看所有用户
     */
    @GetMapping()
    public Result<List<UserAuth>> getAll() {
        System.out.println("get all users");
        return Result.ok(userAuthService.list());
    }

    /**
     * 根据id查特定用户
     */
    @GetMapping("/users/{userId}")
    public Result getUserById(@PathVariable("userId") Integer userId) {
        return Result.ok(userAuthService.getById(userId));
    }
    /*******END 微服务接口*******/

    /**
     * 获取用户区域分布
     *
     * @param conditionVO 条件
     * @return {@link Result<UserAreaDTO>} 用户区域分布
     */
    @ApiOperation(value = "获取用户区域分布")
    @GetMapping("/admin/users/area")
    public Result<List<UserAreaDTO>> listUserAreas(ConditionVO conditionVO) {
        return Result.ok(userAuthService.listUserAreas(conditionVO));
    }

    /**
     * 查询后台用户列表
     *
     * @param condition 条件
     * @return {@link Result<UserBackDTO>} 用户列表
     */
    @ApiOperation(value = "查询后台用户列表")
    @GetMapping("/admin/users")
    public Result<PageResult<UserBackDTO>> listUsers(ConditionVO condition) {
        System.out.println("/admin/users");
        return Result.ok(userAuthService.listUserBackDTO(condition));
    }

    /**
     * 用户注册
     *
     * @param user 用户信息
     * @return {@link Result<>}
     */
    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
    public Result<?> register(@Valid @RequestBody UserVO user) {
        userAuthService.register(user);
        return Result.ok();
    }

    /**
     * 修改密码
     *
     * @param user 用户信息
     * @return {@link Result<>}
     */
    @ApiOperation(value = "修改密码")
    @PutMapping("/users/password")
    public Result<?> updatePassword(@Valid @RequestBody UserVO user) {
        userAuthService.updatePassword(user);
        return Result.ok();
    }

    /**
     * 修改管理员密码
     *
     * @param passwordVO 密码信息
     * @return {@link Result<>}
     */
    @ApiOperation(value = "修改管理员密码")
    @PutMapping("/admin/users/password")
    public Result<?> updateAdminPassword(@Valid @RequestBody PasswordVO passwordVO) {
        userAuthService.updateAdminPassword(passwordVO);
        return Result.ok();
    }

}
