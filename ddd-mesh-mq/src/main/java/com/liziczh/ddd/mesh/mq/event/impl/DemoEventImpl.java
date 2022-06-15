package com.liziczh.ddd.mesh.mq.event.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.liziczh.ddd.mesh.common.util.JsonUtils;
import com.liziczh.ddd.mesh.domain.data.DemoEventDO;
import com.liziczh.ddd.mesh.domain.event.DemoEvent;

/**
 * Demo事件发送
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2022/1/16 12:11 上午
 */
@Service
public class DemoEventImpl implements DemoEvent {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void publishEvent(DemoEventDO eventDO) {
        String topic = "test_topic";
        kafkaTemplate.send(topic, JsonUtils.toJson(eventDO));
    }
}
