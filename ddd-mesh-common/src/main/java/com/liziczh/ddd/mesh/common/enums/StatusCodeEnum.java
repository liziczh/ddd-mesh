package com.liziczh.ddd.mesh.common.enums;

import java.util.Objects;

/**
 * 状态码枚举
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2022/1/16 12:50 下午
 */
public enum StatusCodeEnum {
    SUCCESS("100200", "成功"),
    ERROR("100500", "系统错误");

    private String code;
    private String desc;

    StatusCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static StatusCodeEnum getEnum(Integer code) {
        if (Objects.nonNull(code)) {
            for (StatusCodeEnum value : StatusCodeEnum.values()) {
                if (value.getCode().equals(code)) {
                    return value;
                }
            }
        }
        return null;
    }
}
