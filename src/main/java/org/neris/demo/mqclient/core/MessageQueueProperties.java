package org.neris.demo.mqclient.core;

import lombok.Data;

import java.util.Map;

@Data
public class MessageQueueProperties {

    private Map<String,String> ProducerProviders;

}
