package com.liziczh.ddd.mesh.application.service.impl;

import com.liziczh.ddd.mesh.api.condition.DemoCondition;
import com.liziczh.ddd.mesh.api.dto.DemoDTO;
import com.liziczh.ddd.mesh.api.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class DemoServiceImpl implements DemoService {


    @Override
    public List<DemoDTO> selectPage(DemoCondition condition) throws Exception {
        return null;
    }

    @Override
    public List<DemoDTO> selectByCondition(DemoCondition condition) throws Exception {
        return null;
    }

    @Override
    public Integer addDemo(DemoDTO demo) throws Exception {
        return null;
    }

    @Override
    public void updateDemo(DemoDTO demo) throws Exception {

    }

    @Override
    public DemoDTO getDemo(String id) throws Exception {
        return null;
    }

    @Override
    public void deleteDemo(String id) throws Exception {

    }

    @Override
    public String refHello() {
        return null;
    }
}
