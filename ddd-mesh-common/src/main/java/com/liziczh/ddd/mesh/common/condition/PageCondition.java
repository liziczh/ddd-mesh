package com.liziczh.ddd.mesh.common.condition;

import lombok.Data;

import java.io.Serializable;

/**
 * common
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2021/7/17 21:52
 */
@Data
public class PageCondition implements Serializable {
    private static final long serialVersionUID = 1487852855435923600L;
    private Integer pageNo = 1;
    private Integer size = 20;

    public PageCondition pageNo(Integer pageNo) {
        this.pageNo = pageNo;
        return this;
    }

    public PageCondition size(Integer size) {
        this.size = size;
        return this;
    }
}
