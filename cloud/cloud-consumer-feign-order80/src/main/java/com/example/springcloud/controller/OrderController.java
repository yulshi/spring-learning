package com.example.springcloud.controller;

import com.example.springcloud.entities.CommonResult;
import com.example.springcloud.entities.Payment;
import com.example.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yulshi
 * @create 2020/05/27 18:09
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/timeout")
    public String timeout() {
        return paymentService.timeout();
    }

}
