package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author yulshi
 * @create 2020/05/27 18:07
 */
@SpringBootApplication
@EnableFeignClients
public class FeignOrderMain80 {

  public static void main(String[] args) {
    SpringApplication.run(FeignOrderMain80.class, args);
  }

}

