package com.example.tx;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author yulshi
 * @create 2020/06/05 09:25
 */
@Component
public class MyBeanFactoryPostRegistry implements BeanDefinitionRegistryPostProcessor {
  @Override
  public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
    System.out.println("MyBeanFactoryPostRegistry...postProcessBeanDefinitionRegistry");
  }

  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
    System.out.println("MyBeanFactoryPostRegistry...postProcessBeanFactory");
  }
}
