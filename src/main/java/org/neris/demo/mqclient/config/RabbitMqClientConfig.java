package org.neris.demo.mqclient.config;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

@Configuration
@ConditionalOnProperty({"rabbit-mq.client.enabled"})
@EnableRabbit
@ComponentScan(basePackages = {"org.neris.demo.mqclient.rabbitmq"})
public class RabbitMqClientConfig {
}
