package com.richand.kafka1.api.controller;

import com.richand.kafka1.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka-demo1")
public class KafkaDemo1Controller {

    @Autowired
    private KafkaProducer kafkaProducer;

        @GetMapping("/message")
    public String sendMessage(@RequestParam String message){
        kafkaProducer.senMessage(message);
        return "mensaje enviado exitosamente";
    }
}
