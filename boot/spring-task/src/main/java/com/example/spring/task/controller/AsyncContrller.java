package com.example.spring.task.controller;

import com.example.spring.task.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yulshi
 * @create 2020/06/14 12:19
 */
@RestController
@Slf4j
public class AsyncContrller {

    private final AsyncService asyncService;

    public AsyncContrller(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    @GetMapping("/task/async")
    public String asyncTaks() {
        asyncService.longtimeRunning();
        log.info("say 'Aloha' to everyone");
        return "Aloha";
    }
}
