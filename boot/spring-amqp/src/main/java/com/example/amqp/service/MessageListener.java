package com.example.amqp.service;

import com.example.amqp.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author yulshi
 * @create 2020/06/08 17:43
 */
@Service
public class MessageListener {

    @RabbitListener(queues = "oracle")
    public void onMessage(Book book) {
        System.out.println("received: " + book);
    }

}
