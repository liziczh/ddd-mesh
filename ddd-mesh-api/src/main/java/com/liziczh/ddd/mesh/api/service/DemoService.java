package com.liziczh.ddd.mesh.api.service;

import com.liziczh.ddd.mesh.api.req.DemoCommandReq;
import com.liziczh.ddd.mesh.api.req.DemoQueryReq;
import com.liziczh.ddd.mesh.api.dto.DemoDTO;
import com.liziczh.ddd.mesh.api.response.BaseResponse;

import java.util.List;

public interface DemoService {

    /**
     * 分页条件查询
     *
     * @param req
     * @return java.util.List<com.liziczh.ddd.mesh.api.dto.DemoDTO>
     * @author chenzhehao
     * @date 2022/1/17 12:37 上午
     */
    BaseResponse<List<DemoDTO>> queryPage(DemoQueryReq req) throws Exception;

    /**
     * 查询单个实体信息
     *
     * @param demoId
     * @return com.liziczh.ddd.mesh.api.dto.DemoDTO
     * @author chenzhehao
     * @date 2022/1/17 12:41 上午
     */
    BaseResponse<DemoDTO> getDemo(Long demoId) throws Exception;

    /**
     * 新增实体
     *
     * @param req
     * @return java.lang.Integer
     * @author chenzhehao
     * @date 2022/1/17 12:41 上午
     */
    BaseResponse<DemoDTO> addDemo(DemoCommandReq req) throws Exception;

    /**
     * 更新实体
     *
     * @param demo
     * @return com.liziczh.ddd.mesh.api.response.BaseResponse<com.liziczh.ddd.mesh.api.dto.DemoDTO>
     * @author chenzhehao
     * @date 2022/1/17 12:53 上午
     */
    BaseResponse<DemoDTO> updateDemo(DemoCommandReq demo) throws Exception;

   /**
    * 删除实体
    *
    * @param demoId
    * @return com.liziczh.ddd.mesh.api.response.BaseResponse<com.liziczh.ddd.mesh.api.dto.DemoDTO>
    * @author chenzhehao
    * @date 2022/1/17 12:53 上午
    */
    BaseResponse<DemoDTO> deleteDemo(Long demoId) throws Exception;

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
