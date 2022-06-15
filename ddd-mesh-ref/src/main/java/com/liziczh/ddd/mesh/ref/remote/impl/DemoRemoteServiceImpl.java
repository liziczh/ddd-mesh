package com.liziczh.ddd.mesh.ref.remote.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liziczh.ddd.mesh.domain.data.DemoDO;
import com.liziczh.ddd.mesh.domain.data.DemoExternalDO;
import com.liziczh.ddd.mesh.domain.ref.DemoRemoteService;
import com.liziczh.ddd.mesh.ref.demo.DemoRefService;

import lombok.extern.slf4j.Slf4j;

/**
 * common
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2022/6/15 10:09 下午
 */
@Slf4j
@Service
public class DemoRemoteServiceImpl implements DemoRemoteService {

    @Autowired
    private DemoRefService demoRefService;

    @Override
    public DemoExternalDO callRemoteService(DemoDO demoDO) {
        return null;
    }

}
