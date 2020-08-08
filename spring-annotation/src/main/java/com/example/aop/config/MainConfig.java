package com.example.aop.config;

import com.example.aop.aspect.LogAspect;
import com.example.aop.servcie.Calculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author yulshi
 * @create 2020/06/04 14:01
 */
@EnableAspectJAutoProxy
@Configuration
public class MainConfig {

  @Bean
  Calculator calculator() {
    return new Calculator();
  }

  @Bean
  LogAspect logAspect() {
    return new LogAspect();
  }

}
