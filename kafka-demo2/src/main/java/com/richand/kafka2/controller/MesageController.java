package com.richand.kafka2.controller;

import com.richand.kafka2.kafka.JsonKafkaProducer;
import com.richand.kafka2.kafka.KafkaProducer;
import com.richand.kafka2.payload.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka-demo-2")
public class MesageController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private JsonKafkaProducer jsonKafkaProducer;

    @PostMapping("/getMessage")
    public ResponseEntity<String> sendMessage(String message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok().body("Message sent to the topic");
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendJson(@RequestBody User user){
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Json send to the topic");
    }
}
