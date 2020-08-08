package com.example.springcloud.controller;

import com.example.springcloud.service.MessageProducer;
import com.example.springcloud.service.impl.MessageProducerImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yulshi
 * @create 2020/05/30 12:47
 */
@RestController
public class SendMessageController {

  @Resource
  private MessageProducer producer;

  @GetMapping("/send")
  public String sendMessage() {
    return producer.send();
  }

}
