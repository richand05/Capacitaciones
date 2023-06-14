package com.richand.kafka.controller;

import com.richand.kafka.helper.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("kafka-controller")
public class KafkaController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping("/{message}")
    public String senMessage(@PathVariable String message){
        String response = "successful process";
        try{
            kafkaProducer.sendMessage(message);
        }catch (Exception e){
            response = "Failed process";
        }
        return response;
    }
}
