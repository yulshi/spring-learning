package com.example.springcloud.service.impl;

import com.example.springcloud.service.MessageProducer;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author yulshi
 * @create 2020/05/30 12:44
 */
@EnableBinding(Source.class)
public class MessageProducerImpl implements MessageProducer {

    @Resource(name = "output")
    private MessageChannel channel;

    @Override
    public String send() {
        String sid = UUID.randomUUID().toString();
        channel.send(MessageBuilder.withPayload(sid).build());
        return sid;
    }
}
