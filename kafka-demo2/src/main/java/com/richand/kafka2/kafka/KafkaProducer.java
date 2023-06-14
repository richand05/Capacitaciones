package com.richand.kafka2.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    private final String topic = "kafka-demo-2";

    public void sendMessage(String message){
        LOGGER.info(String.format("Message: %s", message));
        kafkaTemplate.send(topic, message);
    }
}
