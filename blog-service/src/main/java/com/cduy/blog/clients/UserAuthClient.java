package com.cduy.blog.clients;

import com.cduy.blog.entity.UserAuth;
import com.cduy.blog.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * @author CDUY
 * @version 1.0
 */

@FeignClient("userservice")
public interface UserAuthClient {

    @GetMapping("/users/{id}")
    Result<UserAuth> findById(@PathVariable("id")Integer id);
}

