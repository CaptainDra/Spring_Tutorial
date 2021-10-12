package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.producer.Producer;
import com.example.constance.MQModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class APIController {
    private final static Logger logger = LoggerFactory.getLogger(Producer.class);
    @Resource
    private Producer producer;

    @PostMapping(value = "/partition")
    public void partition(@RequestBody MQModel model){
        logger.info("API:{}", JSON.toJSONString(model));
        logger.info("发送第一条可接收的, flag = 1");
        producer.sendMsg1(model);
        logger.info("发送第二条可接收的, flag = 2");
        producer.sendMsg2(model);
    }
}
