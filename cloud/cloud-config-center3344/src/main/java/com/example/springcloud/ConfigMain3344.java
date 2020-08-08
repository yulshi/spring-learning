package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author yulshi
 * @create 2020/05/29 21:30
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigMain3344 {

  public static void main(String[] args) {
    SpringApplication.run(ConfigMain3344.class, args);
  }

}
