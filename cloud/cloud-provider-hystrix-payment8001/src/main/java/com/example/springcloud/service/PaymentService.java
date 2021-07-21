package com.example.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author yulshi
 * @create 2020/05/27 22:17
 */
@Service
@Slf4j
public class PaymentService {

    public String paymentInfoOK(Integer id) {
        return "thread pool: " + Thread.currentThread().getName() + " paymentInfoOK, id:" + id;
    }

    @HystrixCommand(
            fallbackMethod = "paymentInfoFallback",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
            }
    )
    public String paymentInfoTimeout(Integer id) {
        log.info("PaymentService in provider is invoked with id: " + id);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //int a = 10 / 0;
        return "thread pool: " + Thread.currentThread().getName() + " paymentInfoTimeout, id:" + id;
    }

    private String paymentInfoFallback(Integer id) {
        return "thread pool: " + Thread.currentThread().getName() + " the fallback method, id:" + id;
    }

    /******************** 服务熔断 ************************/
    @HystrixCommand(
            fallbackMethod = "paymentWithCircuitBreakerFallback",
            commandProperties = {
                    @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000")
            }
    )
    public String paymentWithCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("can not be negative");
        } else {
            return "Yeah!!!! " + IdUtil.simpleUUID();
        }
    }

    private String paymentWithCircuitBreakerFallback(Integer id) {
        return "id can not be negative!!!";
    }

}
