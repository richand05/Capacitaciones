package com.richand.kafka2.kafka;

import com.richand.kafka2.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "kafka-demo-5", groupId = "myGroup")
    public void consumer(User user){
        LOGGER.info(String.format("The consumer message is (json user): ", user.toString()));
    }
}
