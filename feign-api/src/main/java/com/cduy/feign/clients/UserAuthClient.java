package com.cduy.feign.clients;

import com.cduy.feign.domain.UserAuth;
import com.cduy.feign.vo.Result;
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
    Result<UserAuth> findById(@PathVariable("id") Integer id);
}

