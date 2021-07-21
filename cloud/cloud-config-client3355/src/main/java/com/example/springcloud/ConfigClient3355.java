package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author yulshi
 * @create 2020/05/30 09:03
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClient3355 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClient3355.class, args);
    }

}
