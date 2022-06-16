package com.liziczh.ddd.mesh.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liziczh.base.api.common.response.BaseResponse;
import com.liziczh.ddd.mesh.api.dto.DemoDTO;
import com.liziczh.ddd.mesh.api.dto.DemoOptDTO;
import com.liziczh.ddd.mesh.api.req.DemoCommandReq;
import com.liziczh.ddd.mesh.api.req.DemoQueryReq;
import com.liziczh.ddd.mesh.api.service.DemoApiService;
import com.liziczh.ddd.mesh.common.response.ResponseBuilder;
import com.liziczh.ddd.mesh.service.bo.DemoBO;
import com.liziczh.ddd.mesh.service.bo.DemoOptBO;
import com.liziczh.ddd.mesh.service.convertor.DemoApiConvertor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DemoApiServiceImpl implements DemoApiService {

    @Autowired
    private DemoService demoService;

    @Autowired
    private DemoApiConvertor demoApiConvertor;

    @Override
    public BaseResponse<List<DemoDTO>> queryPage(DemoQueryReq req) {
        BaseResponse<List<DemoBO>> response = demoService.queryPage(req);
        return ResponseBuilder.success(demoApiConvertor.toDTOList(response.getData()));
    }

    @Override
    public BaseResponse<DemoDTO> getDemo(Long demoId) {
        BaseResponse<DemoBO> response = demoService.getDemo(demoId);
        return ResponseBuilder.success(demoApiConvertor.toDTO(response.getData()));
    }

    @Override
    public BaseResponse<DemoOptDTO> addDemo(DemoCommandReq req) {
        BaseResponse<DemoOptBO> response = demoService.addDemo(req);
        return ResponseBuilder.success(demoApiConvertor.toDTO(response.getData()));
    }

    @Override
    public BaseResponse<DemoOptDTO> updateDemo(DemoCommandReq demo) {
        BaseResponse<DemoOptBO> response = demoService.updateDemo(demo);
        return ResponseBuilder.success(demoApiConvertor.toDTO(response.getData()));
    }

    @Override
    public BaseResponse<DemoOptDTO> deleteDemo(Long demoId) {
        BaseResponse<DemoOptBO> response = demoService.deleteDemo(demoId);
        return ResponseBuilder.success(demoApiConvertor.toDTO(response.getData()));
    }

    @Override
    public BaseResponse<String> refTest() {
        return demoService.refTest();
    }

}
