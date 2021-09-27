package com.example.controller;

import com.example.producer.Producer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class APIController {
    @Resource
    private Producer producer;

    @PostMapping(value = "/dev")
    public void dev(String message){
        producer.sendMsg("hi");
    }
}
