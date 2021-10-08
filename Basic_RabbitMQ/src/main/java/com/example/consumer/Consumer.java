package com.example.consumer;

import com.example.constance.MQModel;
import com.example.constance.MqConstants;
import com.example.rabbitstream.RabbitStreamAPI;
import org.springframework.amqp.core.Message;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.LocalServerPort;
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
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
@EnableBinding(RabbitStreamAPI.class)
public class Consumer {
    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @StreamListener(MqConstants.DEV_EXCHANGE)
    public void receiveMsgAutoCommit(@Payload String payload) {
        logger.info("consumer:{}", payload);
    }

}