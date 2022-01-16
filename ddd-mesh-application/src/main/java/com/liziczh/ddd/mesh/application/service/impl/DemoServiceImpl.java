package com.liziczh.ddd.mesh.application.service.impl;

import com.liziczh.ddd.mesh.api.req.DemoCommandReq;
import com.liziczh.ddd.mesh.api.req.DemoQueryReq;
import com.liziczh.ddd.mesh.api.dto.DemoDTO;
import com.liziczh.ddd.mesh.api.response.Result;
import com.liziczh.ddd.mesh.api.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public Result<List<DemoDTO>> queryPage(DemoQueryReq req) throws Exception {
        return null;
    }

    @Override
    public Result<DemoDTO> getDemo(Long demoId) throws Exception {
        return null;
    }

    @Override
    public Result<DemoDTO> addDemo(DemoCommandReq req) throws Exception {
        return null;
    }

    @Override
    public Result<DemoDTO> updateDemo(DemoCommandReq demo) throws Exception {
        return null;
    }

    @Override
    public Result<DemoDTO> deleteDemo(Long demoId) throws Exception {
        return null;
    }

    @Override
    public Result<String> refTest() {
        return null;
    }

}
