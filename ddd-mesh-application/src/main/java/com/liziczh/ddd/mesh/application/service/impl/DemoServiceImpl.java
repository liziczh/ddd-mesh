package com.liziczh.ddd.mesh.application.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liziczh.ddd.mesh.api.dto.DemoDTO;
import com.liziczh.ddd.mesh.api.req.DemoCommandReq;
import com.liziczh.ddd.mesh.api.req.DemoQueryReq;
import com.liziczh.ddd.mesh.api.response.BaseResponse;
import com.liziczh.ddd.mesh.api.service.DemoService;
import com.liziczh.ddd.mesh.application.convertor.DemoDTOConvertor;
import com.liziczh.ddd.mesh.common.response.ResponseBuilder;
import com.liziczh.ddd.mesh.domain.entity.DemoEntity;
import com.liziczh.ddd.mesh.domain.repository.DemoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoRepository demoRepository;

    @Autowired
    private DemoDTOConvertor demoDTOConvertor;

    @Override
    public BaseResponse<List<DemoDTO>> queryPage(DemoQueryReq req) {
        List<DemoEntity> entityList = demoRepository.selectByCondition(req);
        List<DemoDTO> demoDTOList = demoDTOConvertor.toDTOList(entityList);
        return ResponseBuilder.success(demoDTOList);
    }

    @Override
    public BaseResponse<DemoDTO> getDemo(Long demoId) {
        DemoEntity entity = demoRepository.get(demoId);
        DemoDTO dto = demoDTOConvertor.toDTO(entity);
        return ResponseBuilder.success(dto);
    }

    @Override
    public BaseResponse<DemoDTO> addDemo(DemoCommandReq req) {
        return null;
    }

    @Override
    public BaseResponse<DemoDTO> updateDemo(DemoCommandReq demo) {
        return null;
    }

    @Override
    public BaseResponse<DemoDTO> deleteDemo(Long demoId) {
        return null;
    }

    @Override
    public BaseResponse<String> refTest() {
        return null;
    }

}
