package com.cduy.user.controller;

import com.cduy.user.config.PatternProperties;
import com.cduy.user.domain.UserAuth;
import com.cduy.user.service.UserAuthService;
import com.cduy.user.vo.Result;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author CDUY
 * @version 1.0
 */
@RestController
@RequestMapping("/users")
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

    @GetMapping("now")
    public String now() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(properties.getDateformat()));
    }
    /*******END 配置热更新*******/


    /*******START 多环境配置共享*******/
    @GetMapping("prop")
    public PatternProperties properties() {
        return properties;
    }
    /*******END 多环境配置共享*******/

    /**
     * 查看所有用户
     */
    @GetMapping
    public Result<List<UserAuth>> getAll() {
        System.out.println("get all users");
        return Result.ok(userAuthService.list());
    }

    /**
     * 根据id查特定用户
     */
    @GetMapping("/{userId}")
    public Result getUserById(@PathVariable("userId") Integer userId) {
        return Result.ok(userAuthService.getById(userId));
    }

}
