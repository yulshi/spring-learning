package com.example.amqp.service;

import com.example.amqp.bean.Book;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yulshi
 * @create 2020/06/08 18:01
 */
@Service
public class BookService {

  @Autowired
  RabbitTemplate rabbitTemplate;

  @Autowired
  AmqpAdmin amqpAdmin;

  public void addBook(Book book) {
    rabbitTemplate.convertAndSend("exchange.direct", "oracle", book);
  }

}
