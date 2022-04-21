package com.cduy.blog;

import org.mybatis.spring.annotation.MapperScan;
import com.cduy.feign.clients.UserAuthClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@MapperScan("com.cduy.blog.dao")
@EnableFeignClients(clients = UserAuthClient.class)//开启feign开关
public class BlogServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogServiceApplication.class, args);
    }

    @Bean
    @LoadBalanced//用于实现负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
