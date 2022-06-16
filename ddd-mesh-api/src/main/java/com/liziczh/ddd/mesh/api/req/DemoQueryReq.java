package com.liziczh.ddd.mesh.api.req;

import com.liziczh.base.api.condition.BaseCondition;

import lombok.Data;

/**
 * 实体查询条件
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2021/7/17 21:52
 */
@Data
public class DemoQueryReq extends BaseCondition {
    /**
     * 实体ID
     */
    private Long demoId;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 名称
     */
    private String name;
    /**
     * 状态
     */
    private Integer status;
}
