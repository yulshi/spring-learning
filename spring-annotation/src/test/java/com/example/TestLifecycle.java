package com.example;

import com.example.ioc.config.LifecycleConfig;
import com.example.ioc.entity.Dog;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * @author yulshi
 * @create 2020/06/04 08:28
 */
public class TestLifecycle {

    @Test
    public void testLifecycle() {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(LifecycleConfig.class);
        applicationContext.getEnvironment().setActiveProfiles("test");
        applicationContext.register(LifecycleConfig.class);
        applicationContext.refresh();
        Map<String, Dog> beans = applicationContext.getBeansOfType(Dog.class);
        beans.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });

        applicationContext.close();

    }

}
