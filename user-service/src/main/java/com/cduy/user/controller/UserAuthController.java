package com.cduy.user.controller;

import com.cduy.user.domain.UserAuth;
import com.cduy.user.service.UserAuthService;
import com.cduy.user.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author CDUY
 * @version 1.0
 */
@RestController
@RequestMapping("/users")
public class UserAuthController {

    @Autowired
    private UserAuthService userAuthService;

    /**
     * 查看所有用户
     * */
    @GetMapping
    public Result<List<UserAuth>> getAll() {
        System.out.println("get all users");
        return Result.ok(userAuthService.list());
    }
}
