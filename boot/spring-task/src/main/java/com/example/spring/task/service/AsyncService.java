package com.example.spring.task.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author yulshi
 * @create 2020/06/14 12:15
 */
@Service
@Slf4j
public class AsyncService {
    @Async
    public void longtimeRunning() {
        log.info("Start a long-running task...");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
        }
        log.info("The long-running task finished");
    }
}
