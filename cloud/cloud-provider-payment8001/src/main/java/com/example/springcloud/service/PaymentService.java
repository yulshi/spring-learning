package com.example.springcloud.service;

import com.example.springcloud.entities.Payment;

/**
 * @author yulshi
 * @create 2020/05/26 20:53
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);

}
