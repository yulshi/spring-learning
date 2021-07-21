package com.example.springcloud.controller;

import com.example.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yulshi
 * @create 2020/05/28 18:14
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "globalFallback")
public class OrderController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String goodInvoke(@PathVariable("id") Integer id) {
        return paymentService.paymentInfoOk(id);
    }

    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String badInvoke(@PathVariable Integer id) {
        log.info("invoking payment service#paymentInfoTimeout ...");
        return paymentService.paymentInfoTimeout(id);
    }

    private String fallback(Integer id) {
        return "consumer-fallback method is invoked";
    }

    private String globalFallback() {
        return "consumer-GLOBAL-fallback method is invoked";
    }

}
