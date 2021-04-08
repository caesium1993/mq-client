package org.neris.demo.mqclient.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "spring.rabbitmq",value = "enabled",havingValue = "true")
public class RabbitConfig {

    /**
     * 声明交换机
     * String: 交换机名称
     * Boolean: 是否持久化
     * Boolean: 是否自动删除
     */
    /** Direct Exchange **/
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("DIRECT_EXCHANGE", true, false);
    }
    /** Topic Exchange **/
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("TOPIC_EXCHANGE", true, false);
    }
    /** Fanout Exchange **/
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("FANOUT_EXCHANGE", true, false);
    }

    /**
     * 声明消息队列
     * String: 消息队列名称
     * Boolean: 是否持久化
     */
    @Bean
    public Queue myQueue() {
        return new Queue("MY_QUEUE", true);
    }
    @Bean
    public Binding myBinding() {
        return BindingBuilder.bind(myQueue()).to(directExchange()).with("mq.hello");
    }
}
