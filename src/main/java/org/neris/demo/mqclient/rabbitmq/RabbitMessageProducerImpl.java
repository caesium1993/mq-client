package org.neris.demo.mqclient.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.neris.demo.mqclient.core.MessageProducer;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service(value = "RabbitMessageProducer")
public class RabbitMessageProducerImpl implements MessageProducer {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Override
    public void send(String message) {
        rabbitTemplate.convertAndSend("MY_QUEUE", message);
        log.info("======sending a message: "+message);
    }
}
