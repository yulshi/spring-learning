package com.example.springcloud.controller;

import com.example.springcloud.entities.CommonResult;
import com.example.springcloud.entities.Payment;
import com.example.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yulshi
 * @create 2020/05/26 20:56
 */
@Slf4j
@RestController
public class PaymentController {

  @Value("${server.port}")
  private String serverPort;

  @Resource
  private PaymentService paymentService;

  @Resource
  private DiscoveryClient discoveryClient;

  @PostMapping("/payment/create")
  public CommonResult<Integer> create(@RequestBody Payment payment) {

    log.info("payment being add in payment: " + payment.getSerial());

    int result = paymentService.create(payment);
    log.debug("result of insertion: " + result);

    if (result > 0) {
      return new CommonResult<Integer>(200, "insert successfully thru " + serverPort, result);
    } else {
      return new CommonResult<>(444, "failed at " + serverPort);
    }
  }

  @GetMapping("/payment/get/{id}")
  public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {

    Payment payment = paymentService.getPaymentById(id);

    if (payment != null) {
      return new CommonResult(200, "success thru " + serverPort, payment);
    } else {
      return new CommonResult<>(444, "fail to get thru " + serverPort + id);
    }

  }

  @GetMapping("/payment/lb")
  public String serverPort() {
    return serverPort;
  }

  @GetMapping("/payment/discovery")
  public Object discover() {
    for (String service : discoveryClient.getServices()) {
      log.info("service: " + service);
    }

    List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
    for (ServiceInstance instance : instances) {
      log.info("instance: " + instance.getHost() + ":" + instance.getPort() + "," + instance.getUri());
    }

    return discoveryClient;

  }

  @GetMapping("/payment/timeout")
  public String timeout() {

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    return serverPort;

  }

  @GetMapping("/payment/zipkin")
  public String zipkin() {
    return "This is for testing zipkin: " + serverPort;
  }

}
