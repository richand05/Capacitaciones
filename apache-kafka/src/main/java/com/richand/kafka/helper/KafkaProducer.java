package com.richand.kafka.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    private final String kafkaTopic = "basic-test-topic";

    public void sendMessage(String message){
        kafkaTemplate.send(kafkaTopic, message);
    }
}
