package com.liziczh.ddd.mesh.service.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liziczh.ddd.mesh.api.common.response.BaseResponse;
import com.liziczh.ddd.mesh.api.req.DemoCommandReq;
import com.liziczh.ddd.mesh.api.req.DemoQueryReq;
import com.liziczh.ddd.mesh.common.response.ResponseBuilder;
import com.liziczh.ddd.mesh.domain.entity.DemoEntity;
import com.liziczh.ddd.mesh.domain.repository.DemoRepository;
import com.liziczh.ddd.mesh.service.bo.DemoBO;
import com.liziczh.ddd.mesh.service.bo.DemoOptBO;
import com.liziczh.ddd.mesh.service.convertor.DemoBOConvertor;
import com.liziczh.ddd.mesh.service.service.DemoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoRepository demoRepository;

    @Autowired
    private DemoBOConvertor demoBOConvertor;

    @Override
    public BaseResponse<List<DemoBO>> queryPage(DemoQueryReq req) {
        List<DemoEntity> entityList = demoRepository.selectByCondition(req);
        List<DemoBO> demoBOList = demoBOConvertor.toBOList(entityList);
        return ResponseBuilder.success(demoBOList);
    }

    @Override
    public BaseResponse<DemoBO> getDemo(Long demoId) {
        DemoEntity entity = demoRepository.get(demoId);
        DemoBO dto = demoBOConvertor.toBO(entity);
        return ResponseBuilder.success(dto);
    }

    @Override
    public BaseResponse<DemoOptBO> addDemo(DemoCommandReq req) {
        return null;
    }

    @Override
    public BaseResponse<DemoOptBO> updateDemo(DemoCommandReq demo) {
        return null;
    }

    @Override
    public BaseResponse<DemoOptBO> deleteDemo(Long demoId) {
        return null;
    }

    @Override
    public BaseResponse<String> refTest() {
        return null;
    }

}
