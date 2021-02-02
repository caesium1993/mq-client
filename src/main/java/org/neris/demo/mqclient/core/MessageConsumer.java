package org.neris.demo.mqclient.core;

public interface MessageConsumer {

    void process(String message);

}
