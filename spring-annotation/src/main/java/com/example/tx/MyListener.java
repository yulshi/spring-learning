package com.example.tx;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author yulshi
 * @create 2020/06/05 09:52
 */
@Component
public class MyListener implements ApplicationListener<ApplicationEvent> {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("::::::" + event);
    }
}
