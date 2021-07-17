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
public class SortCondition implements Serializable {
    private static final long serialVersionUID = 2685484123703694389L;
    private String columnName;
    private OrderType orderType;

    /**
     * 排序类型
     */
    public enum OrderType {
        ASC("ASC", "升序"),
        DESC("DESC", "降序");

        private String code;
        private String name;

        private OrderType(String code, String name) {
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }
}
