package org.neris.demo.mqclient.config;

import org.neris.demo.mqclient.core.MessageQueueProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/message-queue.properties")
@ComponentScan(basePackages = {"org.neris.demo.mqclient.core"})
public class MessageQueueConfig {

    @Bean
    @ConfigurationProperties(prefix = "message-queue")
    public MessageQueueProperties messageQueueProperties(){
        return new MessageQueueProperties();
    }
}
