package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author yulshi
 * @create 2020/05/28 18:10
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class HystrixOrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixOrderMain80.class, args);
    }

}
