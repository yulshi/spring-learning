package com.example.spring.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author yulshi
 * @create 2020/06/14 12:13
 */
@SpringBootApplication
@EnableAsync
@EnableScheduling
public class TaskMain {
    public static void main(String[] args) {
        SpringApplication.run(TaskMain.class, args);
    }
}
