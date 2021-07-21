package org.example.controller;

import org.example.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class OrderController {

    private final RestTemplate restTemplate;
    private final PaymentService paymentService;

    public OrderController(RestTemplate restTemplate, PaymentService paymentService) {
        this.restTemplate = restTemplate;
        this.paymentService = paymentService;
    }

    @GetMapping("/consumer/nacos/{id}")
    public String pay(@PathVariable("id") Integer id) {

        //return restTemplate.getForObject("http://nacos-provider-payment/payment/nacos/" + id, String.class);
        return paymentService.getPayment(id);
    }

}
