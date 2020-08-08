package com.example.ioc.entity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author yulshi
 * @create 2020/06/04 08:18
 */
@Component
@Slf4j
public class Dog {

  private final ApplicationContext context;

  public Dog(ApplicationContext context) {
    log.info("constructing dog");
    this.context = context;
  }

  @PostConstruct
  public void init() {
    System.out.println("Initiating..." + context);
  }

  @PreDestroy
  public void destroy() {
    log.info("Destroying...");
  }

//  @Override
//  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//    this.context = applicationContext;
//  }
}
