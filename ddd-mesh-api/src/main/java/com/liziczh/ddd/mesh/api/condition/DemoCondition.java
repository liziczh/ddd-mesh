package com.liziczh.ddd.mesh.api.condition;

import com.liziczh.ddd.mesh.common.condition.BaseCondition;
import lombok.Data;

import java.util.Date;

@Data
public class DemoCondition extends BaseCondition {
    private static final long serialVersionUID = -7473402179827602416L;
    private Integer id;
    private String name;
    private Date startTime;
    private Date endTime;
    private String valid;
}
