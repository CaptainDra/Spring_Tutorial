package com.example.listenerstream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.Payload;


@SpringBootApplication
@EnableBinding(Sink.class)
public class ListenerStreamApplication {
    private final static Logger logger = LoggerFactory.getLogger(ListenerStreamApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ListenerStreamApplication.class, args);
    }

    @StreamListener(Sink.INPUT)
    public synchronized void receive(@Payload byte[] payload) {
        String out = new String(payload);
        logger.info("Received: " + out);
    }
}
