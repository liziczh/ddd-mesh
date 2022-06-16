package com.liziczh.ddd.mesh.service.service;

import java.util.List;

import com.liziczh.base.api.common.response.BaseResponse;
import com.liziczh.ddd.mesh.api.req.DemoCommandReq;
import com.liziczh.ddd.mesh.api.req.DemoQueryReq;
import com.liziczh.ddd.mesh.service.bo.DemoBO;
import com.liziczh.ddd.mesh.service.bo.DemoOptBO;

public interface DemoService {

    /**
     * 分页条件查询
     *
     * @param req
     * @return java.util.List<com.liziczh.ddd.mesh.api.dto.DemoBO>
     * @author chenzhehao
     * @date 2022/1/17 12:37 上午
     */
    BaseResponse<List<DemoBO>> queryPage(DemoQueryReq req);

    /**
     * 查询单个实体信息
     *
     * @param demoId
     * @return com.liziczh.ddd.mesh.api.dto.DemoBO
     * @author chenzhehao
     * @date 2022/1/17 12:41 上午
     */
    BaseResponse<DemoBO> getDemo(Long demoId);

    /**
     * 新增实体
     *
     * @param req
     * @return java.lang.Integer
     * @author chenzhehao
     * @date 2022/1/17 12:41 上午
     */
    BaseResponse<DemoOptBO> addDemo(DemoCommandReq req);

    /**
     * 更新实体
     *
     * @param demo
     * @return com.liziczh.ddd.mesh.api.common.response.BaseResponse<com.liziczh.ddd.mesh.api.dto.DemoBO>
     * @author chenzhehao
     * @date 2022/1/17 12:53 上午
     */
    BaseResponse<DemoOptBO> updateDemo(DemoCommandReq demo);

    /**
     * 删除实体
     *
     * @param demoId
     * @return com.liziczh.ddd.mesh.api.common.response.BaseResponse<com.liziczh.ddd.mesh.api.dto.DemoBO>
     * @author chenzhehao
     * @date 2022/1/17 12:53 上午
     */
    BaseResponse<DemoOptBO> deleteDemo(Long demoId);

    /**
     * 外部服务调用测试
     *
     * @param
     * @return java.lang.String
     * @author chenzhehao
     * @date 2022/1/17 12:53 上午
     */
    BaseResponse<String> refTest();
}
