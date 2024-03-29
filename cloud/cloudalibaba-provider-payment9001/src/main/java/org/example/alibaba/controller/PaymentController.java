package org.example.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private int port;

    @GetMapping("/payment/nacos/{id}")
    @SentinelResource(value = "payment")
    public String getPayment(@PathVariable("id") Integer id) {
        return "nacos registry, server port: " + port + "\tid: " + id;
    }

}
