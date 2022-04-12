package com.cduy.user.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 加载第三方bean的方式，是分页成为可能
 * @author CDUY
 * @version 1.0
 */
@Configuration
public class MPConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        //1. 定义mp拦截器
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        //2. 添加具体的拦截器专门用于制作分页的拦截器
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }
}
