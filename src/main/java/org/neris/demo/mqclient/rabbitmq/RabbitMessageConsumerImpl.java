package org.neris.demo.mqclient.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.neris.demo.mqclient.core.MessageConsumer;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@RabbitListener(queues = "MY_QUEUE")
@Service(value = "RabbitMessageConsumer")
@Slf4j
public class RabbitMessageConsumerImpl implements MessageConsumer {

    @RabbitHandler
    public void process(String message) {
        log.info("+++++++++=============== receiving a message: "+message);
    }
}
