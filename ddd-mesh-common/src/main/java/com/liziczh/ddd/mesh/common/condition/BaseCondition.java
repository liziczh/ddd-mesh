package com.liziczh.ddd.mesh.common.condition;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * common
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2021/7/17 21:52
 */
@Data
public abstract class BaseCondition implements Serializable {
    private static final long serialVersionUID = 5582629689714183859L;
    private PageCondition page;
    private List<SortCondition> sortList;
    private Date startTime;
    private Date endTime;
}
