/**
 * Baidu.com Inc.
 * Copyright (c) 2021 All Rights Reserved.
 */
package com.liziczh.ddd.mesh.common.id;

import com.liziczh.ddd.mesh.common.util.HostUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * ID生成器
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2021/6/24 4:07 下午
 */
@Slf4j
@Component
public class IdGenerator {

    /**
     * 机器ID
     */
    private long workId;
    /**
     * 数据中心ID
     */
    private long dataCenterId;

    @PostConstruct
    public void init() {
        // 根据HostName初始化机器ID
        this.workId = Math.abs(HostUtils.getHostname().hashCode() % 10000);
        // 根据IP初始化数据中心ID
        this.dataCenterId = Math.abs(HostUtils.getIp().hashCode() % 10000);
    }

    private static volatile SnowFlakeIdWorker instance;

    public SnowFlakeIdWorker getInstance() {
        if (instance == null) {
            synchronized (SnowFlakeIdWorker.class) {
                if (instance == null) {
                    log.info("when instance, workId = {}, datacenterId = {}", workId, dataCenterId);
                    instance = new SnowFlakeIdWorker(workId, dataCenterId);
                }
            }
        }
        return instance;
    }

    /**
     * 获取ID
     *
     * @author chenzhehao
     * @date 2021/6/29 5:19 下午
     */
    public long getId() {
        return this.getInstance().nextId();
    }

}
