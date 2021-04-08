package org.neris.demo.mqclient.core;

import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class DemoApiController {

    private final ApplicationContext applicationContext;

    private final MessageQueueProperties messageQueueProperties;

    public DemoApiController(ApplicationContext applicationContext, MessageQueueProperties messageQueueProperties) {
        this.applicationContext = applicationContext;
        this.messageQueueProperties = messageQueueProperties;
    }

    @GetMapping(value = "/hello")
    public String helloWorld(){
        return "Hello world";
    }

    @GetMapping(value = "/send")
    public String sendMessage(@RequestParam(name = "message")String message,
                              @RequestParam(name = "provider")String provider){

        Map<String, String> producerProviders = messageQueueProperties.getProducerProviders();
        MessageProducer messageProducer = (MessageProducer) applicationContext.getBean(producerProviders.get(provider));
        Assert.notNull(messageProducer,"PROVIDER NOT FOUND");
        messageProducer.send(message);
        return "ok";
    }
}
