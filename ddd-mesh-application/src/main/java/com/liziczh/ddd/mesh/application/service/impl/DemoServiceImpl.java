package com.liziczh.ddd.mesh.application.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.liziczh.ddd.mesh.api.dto.DemoDTO;
import com.liziczh.ddd.mesh.api.req.DemoCommandReq;
import com.liziczh.ddd.mesh.api.req.DemoQueryReq;
import com.liziczh.ddd.mesh.api.response.BaseResponse;
import com.liziczh.ddd.mesh.api.service.DemoService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public BaseResponse<List<DemoDTO>> queryPage(DemoQueryReq req) throws Exception {
        return null;
    }

    @Override
    public BaseResponse<DemoDTO> getDemo(Long demoId) throws Exception {
        return null;
    }

    @Override
    public BaseResponse<DemoDTO> addDemo(DemoCommandReq req) throws Exception {
        return null;
    }

    @Override
    public BaseResponse<DemoDTO> updateDemo(DemoCommandReq demo) throws Exception {
        return null;
    }

    @Override
    public BaseResponse<DemoDTO> deleteDemo(Long demoId) throws Exception {
        return null;
    }

    @Override
    public BaseResponse<String> refTest() {
        return null;
    }

}
