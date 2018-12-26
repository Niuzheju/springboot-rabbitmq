package com.niuzj.springbootrabbitmq.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AMQPService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMessage(String queueName, String msg) {
        amqpTemplate.convertAndSend(queueName, msg);
    }

}
