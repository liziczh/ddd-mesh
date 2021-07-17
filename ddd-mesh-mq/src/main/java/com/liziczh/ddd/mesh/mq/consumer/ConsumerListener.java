package com.liziczh.ddd.mesh.mq.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerListener {
    @KafkaListener(topics = "archetypeTopic")
    public void process(String msg) {
        System.out.println(msg);
    }
}
