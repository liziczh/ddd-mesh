package com.liziczh.ddd.mesh.domain.ref;

import com.liziczh.ddd.mesh.domain.data.DemoDO;
import com.liziczh.ddd.mesh.domain.data.DemoExternalDO;

/**
 * 外部服务调用
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2021/7/18 1:47
 */
public interface DemoExternalService {

    /**
     * 调用外部服务接口
     *
     * @author chenzhehao
     * @date 2021/7/18 1:50
     */
    DemoExternalDO callExternalService(DemoDO demoDO);

}
