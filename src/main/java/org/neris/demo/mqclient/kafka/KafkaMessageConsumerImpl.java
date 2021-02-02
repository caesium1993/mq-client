package org.neris.demo.mqclient.kafka;

import lombok.extern.slf4j.Slf4j;
import org.neris.demo.mqclient.core.MessageConsumer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service(value = "KafkaMessageConsumer")
public class KafkaMessageConsumerImpl implements MessageConsumer {

    @KafkaListener(topics = {"my_topic"})
    @Override
    public void process(String message) {
        log.info("=====kafka-client received a message: "+message+" at "+new Date());
    }
}
