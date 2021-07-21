package org.example.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "nacos-provider-payment")
public interface PaymentService {

    @GetMapping("/payment/nacos/{id}")
    String getPayment(@PathVariable("id") Integer id);

}
