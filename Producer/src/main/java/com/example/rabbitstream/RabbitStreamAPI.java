package com.example.rabbitstream;

import com.example.constance.MqConstants;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface RabbitStreamAPI {
    /**
     * 消息流入（消费）
     **/
    @Input(MqConstants.DEV_EXCHANGE)
    SubscribableChannel Consumer();

    /**
     * 消息流出（生产）
     **/
    @Output(MqConstants.DEV_EXCHANGE)
    MessageChannel Producer();
}
