package com.liziczh.ddd.mesh.api.service;

import com.liziczh.ddd.mesh.api.condition.DemoCondition;
import com.liziczh.ddd.mesh.api.dto.DemoDTO;
import com.liziczh.ddd.mesh.common.service.BaseService;

import java.util.List;

public interface DemoService extends BaseService {
    /**
     * 分页查询
     *
     * @param condition 条件
     * @return List<TDemo>
     * @throws Exception 异常
     */
    List<DemoDTO> selectPage(DemoCondition condition) throws Exception;

    /**
     * 条件查询
     *
     * @param condition 条件
     * @return List<TDemo>
     * @throws Exception 异常
     */
    List<DemoDTO> selectByCondition(DemoCondition condition) throws Exception;

    /**
     * 新增实体
     *
     * @param demo 实体
     * @return pk
     * @throws Exception
     */
    Integer addDemo(DemoDTO demo) throws Exception;

    /**
     * 更新实体
     *
     * @param demo 实体
     * @throws Exception 异常
     */
    void updateDemo(DemoDTO demo) throws Exception;

    /**
     * 查询单个实体
     *
     * @param id id
     * @return TDemo
     * @throws Exception 异常
     */
    DemoDTO getDemo(String id) throws Exception;

    /**
     * 删除实体
     *
     * @param id id
     * @throws Exception 异常
     */
    void deleteDemo(String id) throws Exception;

    /**
     * REF测试
     *
     * @return helloworld
     */
    String refHello();
}
