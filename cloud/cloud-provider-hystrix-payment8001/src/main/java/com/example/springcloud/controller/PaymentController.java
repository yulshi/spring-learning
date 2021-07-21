package com.example.springcloud.controller;

import com.example.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yulshi
 * @create 2020/05/27 22:17
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService service;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id) {
        String result = service.paymentInfoOK(id);
        log.info("*****result: " + result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable("id") Integer id) {
        String result = service.paymentInfoTimeout(id);
        log.info("*****result: " + result);
        return result;
    }

    @GetMapping("/payment/hystrix/circuitbreaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String result = service.paymentWithCircuitBreaker(id);
        return result;
    }


}
