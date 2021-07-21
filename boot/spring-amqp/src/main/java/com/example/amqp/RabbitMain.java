package com.example.amqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yulshi
 * @create 2020/06/08 17:38
 */
@SpringBootApplication
@EnableRabbit
public class RabbitMain {
    public static void main(String[] args) {
        SpringApplication.run(RabbitMain.class, args);
    }
}
