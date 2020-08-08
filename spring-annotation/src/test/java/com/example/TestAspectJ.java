package com.example;

import com.example.aop.config.MainConfig;
import com.example.aop.servcie.Calculator;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author yulshi
 * @create 2020/06/04 14:45
 */
public class TestAspectJ {

  @Test
  public void testCalucator() {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);

    Calculator calculator = context.getBean(Calculator.class);

    System.out.println("calculator: " + calculator);

    calculator.div(6, 3);

    context.close();

  }

}
