package com.example.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author yulshi
 * @create 2020/05/28 20:47
 */
@Component
public class PaymentFallbackService implements PaymentService {
  @Override
  public String paymentInfoOk(Integer id) {
    return "PaymentFallbackService#paymentInfoOk";
  }

  @Override
  public String paymentInfoTimeout(Integer id) {
    return "PaymentFallbackService#paymentInfoTimeout";
  }
}
