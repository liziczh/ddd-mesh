package com.liziczh.archetype.ref.service.impl;

import com.liziczh.archetype.ref.config.RefContextHelper;
import com.liziczh.archetype.ref.service.DemoRefService;
import com.liziczh.ddd.mesh.common.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class DemoRefServiceImpl implements DemoRefService {
    @Autowired
    private RefContextHelper helper;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String hello() {
        String url = helper.getProperty("ARCHETYPE_WEB.DEMO.HELLO");
        ResponseEntity<String> httpEntity = restTemplate.getForEntity(url, String.class);
        log.info(JsonUtils.toJSONString(httpEntity));
        return httpEntity.getBody();
    }
}
