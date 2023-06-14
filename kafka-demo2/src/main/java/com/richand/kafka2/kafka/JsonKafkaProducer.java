package com.richand.kafka2.kafka;

import com.richand.kafka2.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    private static final Logger LOOGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    public void sendMessage(User data){
        LOOGER.info(String.format("The value data user is: %s", data.toString()));
        Message<User> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, "kafka-demo-5")
                .build();

        kafkaTemplate.send(message);


    }
}
