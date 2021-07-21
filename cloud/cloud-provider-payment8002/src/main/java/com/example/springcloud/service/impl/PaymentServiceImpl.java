package com.example.springcloud.service.impl;

import com.example.springcloud.dao.PaymentDao;
import com.example.springcloud.entities.Payment;
import com.example.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yulshi
 * @create 2020/05/26 20:53
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

}
