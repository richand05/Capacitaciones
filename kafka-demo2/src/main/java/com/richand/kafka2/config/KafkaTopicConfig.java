package com.richand.kafka2.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic kafkaDemo2(){
        return TopicBuilder.name("kafka-demo-2")
                .build();
    }

    @Bean
    public NewTopic kafkaDemo3(){
        return TopicBuilder.name("kafka-demo-5")
                .build();
    }
}
