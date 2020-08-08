package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yulshi
 * @create 2020/05/27 12:39
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8004 {

  public static void main(String[] args) {
    SpringApplication.run(PaymentMain8004.class, args);
  }
}
