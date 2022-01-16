package com.liziczh.ddd.mesh.domain.event;

import com.liziczh.ddd.mesh.domain.data.DemoEventDO;

/**
 * 事件
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2021/7/18 1:45
 */
public interface DemoEvent {

    /**
     * 发布事件
     *
     * @author chenzhehao
     * @date 2021/7/18 1:46
     */
    void publishEvent(DemoEventDO eventVO);

}
