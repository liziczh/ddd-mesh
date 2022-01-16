package com.liziczh.ddd.mesh.mq.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * Kafka消费者示例
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2022/1/16 12:11 上午
 */
@Slf4j
@Component
public class ConsumerListener {

    @KafkaListener(topics = "test_topic")
    public void process(String msg) {
        log.info(msg);
    }

}
