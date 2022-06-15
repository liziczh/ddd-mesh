package com.liziczh.ddd.mesh.domain.service.impl;

import org.springframework.stereotype.Component;

import com.liziczh.ddd.mesh.domain.service.DemoDomainService;

import lombok.extern.slf4j.Slf4j;

/**
 * common
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2021/7/18 0:18
 */
@Slf4j
@Component
public class DemoDomainServiceImpl implements DemoDomainService {

    @Override
    public String domainService() {
        return "domainService";
    }
}
