package com.richand.kafka1.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private final String topicName = "kafka-demo-1";

    public void senMessage(String message){
        kafkaTemplate.send(topicName, message);
    }
}
