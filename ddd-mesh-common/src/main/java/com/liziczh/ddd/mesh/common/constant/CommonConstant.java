package com.liziczh.ddd.mesh.common.constant;

/**
 * common
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2021/7/17 21:52
 */
public class CommonConstant {
    /**
     * 数据状态
     */
    public static enum DATA_STATUS {
        VALID(0, "正常"),
        INVALID(1, "失效");

        private Integer code;
        private String name;

        private DATA_STATUS(Integer code, String name) {
            this.code = code;
            this.name = name;
        }

        public Integer getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }
}
