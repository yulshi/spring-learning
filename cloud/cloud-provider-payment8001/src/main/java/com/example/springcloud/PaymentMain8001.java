package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author yulshi
 * @create 2020/05/26 20:13
 */
@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
public class  PaymentMain8001 {

  public static void main(String[] args) {
    SpringApplication.run(PaymentMain8001.class, args);
  }
}
