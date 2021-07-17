package com.liziczh.ddd.mesh.mq.event.impl;

import com.liziczh.ddd.mesh.common.util.FastJsonUtils;
import com.liziczh.ddd.mesh.domain.event.DemoEvent;
import com.liziczh.ddd.mesh.domain.vo.DemoEventVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * common
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2021/7/18 1:51
 */
public class DemoEventImpl implements DemoEvent {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void publishEvent(DemoEventVO eventVO) {
        String topic = "test_topic";
        kafkaTemplate.send(topic, FastJsonUtils.toJson(eventVO));
    }
}
