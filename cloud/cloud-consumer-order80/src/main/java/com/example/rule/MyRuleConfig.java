package com.example.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yulshi
 * @create 2020/05/27 16:28
 */
@Configuration
public class MyRuleConfig {

  @Bean
  public IRule myRule() {
    return new RandomRule();
  }

}
