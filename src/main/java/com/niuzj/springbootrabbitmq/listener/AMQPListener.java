package com.niuzj.springbootrabbitmq.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class AMQPListener {

    //queuesToDeclare队列不存在就创建
    @RabbitListener(queuesToDeclare = @Queue("queue"))
    public void process(String msg, Channel channel, Message message) {
        System.out.println(msg);
        try {
            channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
