package com.niuzj.springbootrabbitmq;

import com.niuzj.springbootrabbitmq.service.AMQPService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRabbitmqApplicationTests {

    @Autowired
    private AMQPService amqpService;

    @Test
    public void contextLoads() {
        for (int i = 0; i < 100; i++) {
            amqpService.sendMessage("queue", "test msg" + (i + 1));
        }
    }

}

