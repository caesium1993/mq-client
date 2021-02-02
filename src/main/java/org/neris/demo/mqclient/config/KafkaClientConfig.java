package org.neris.demo.mqclient.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

@Configuration
@ConditionalOnProperty({"kafka.client.enabled"})
@EnableKafka
@ComponentScan(basePackages = {"org.neris.demo.mqclient.kafka"})
public class KafkaClientConfig {
}
