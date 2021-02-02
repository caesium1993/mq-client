package org.neris.demo.mqclient.kafka;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.neris.demo.mqclient.core.MessageProducer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Data
@Service(value = "KafkaMessageProducer")
public class KafkaMessageProducerImpl implements MessageProducer {

    private final KafkaTemplate kafkaTemplate;

    private static final String KAFKA_TOPIC = "my_topic";

    public KafkaMessageProducerImpl(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String message) {

        kafkaTemplate.send(KAFKA_TOPIC, message);
    }
}
