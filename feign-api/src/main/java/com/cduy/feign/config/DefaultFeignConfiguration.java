package com.cduy.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @author CDUY
 * @version 1.0
 */
public class DefaultFeignConfiguration {
    @Bean
    public Logger.Level logLevel() {
        return Logger.Level.NONE;
    }
}
