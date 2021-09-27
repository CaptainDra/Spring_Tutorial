package com.example.producer;

import com.example.rabbitstream.RabbitStreamAPI;
import org.springframework.amqp.core.Message;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.Router;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@EnableBinding(RabbitStreamAPI.class)
public class Producer{
    private final static Logger logger = LoggerFactory.getLogger(Producer.class);
    private final RabbitStreamAPI rabbitStreamAPI;

    public Producer(RabbitStreamAPI rabbitStreamAPI){
        this.rabbitStreamAPI = rabbitStreamAPI;
    }

    public void sendMsg(String message) {
        rabbitStreamAPI.Producer().send(MessageBuilder.withPayload(message).build());
    }
}
