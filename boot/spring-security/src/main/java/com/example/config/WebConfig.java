package com.example.config;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpSessionListener;

/**
 * @author yulshi
 * @create 2020/06/14 18:24
 */
@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addStatusController("/error/404", HttpStatus.NOT_FOUND);
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
    }

    /**
     * 注册org.springframework.security.web.session.HttpSessionEventPublisher到web.xml中
     */
    @Bean
    ServletListenerRegistrationBean<HttpSessionListener> servletListenerRegistrationBean() {
        return new ServletListenerRegistrationBean<>(new HttpSessionEventPublisher());
    }
}
