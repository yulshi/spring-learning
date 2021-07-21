package com.example.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yulshi
 * @create 2020/05/27 20:22
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLogLevel() {
        return Logger.Level.FULL;
    }

}
