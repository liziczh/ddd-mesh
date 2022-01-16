package com.liziczh.ddd.mesh.common.response;

import com.liziczh.ddd.mesh.api.response.Result;
import com.liziczh.ddd.mesh.common.enums.StatusCodeEnum;

import lombok.Data;

/**
 * 响应体构建器
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2021/12/10 11:06 下午
 */
@Data
public class ResultBuilder<T> {

    /**
     * 通用操作成功
     *
     * @param
     * @return com.liziczh.ddd.mesh.api.response.Result<T>
     * @author chenzhehao
     * @date 2022/1/16 9:47 下午
     */
    public static <T> Result<T> success() {
        return new Result<T>()
                .status(StatusCodeEnum.SUCCESS.getCode())
                .message(StatusCodeEnum.SUCCESS.getDesc());
    }

    /**
     * 通用操作成功
     *
     * @param data
     * @return com.liziczh.ddd.mesh.api.response.Result<T>
     * @author chenzhehao
     * @date 2022/1/16 9:47 下午
     */
    public static <T> Result<T> success(T data) {
        return new Result<T>()
                .status(StatusCodeEnum.SUCCESS.getCode())
                .message(StatusCodeEnum.SUCCESS.getDesc())
                .data(data);
    }

    /**
     * 通用系统错误
     *
     * @param
     * @return com.liziczh.ddd.mesh.api.response.Result<T>
     * @author chenzhehao
     * @date 2022/1/16 9:47 下午
     */
    public static <T> Result<T> error() {
        return new Result<T>()
                .status(StatusCodeEnum.ERROR.getCode())
                .message(StatusCodeEnum.ERROR.getDesc());
    }

    /**
     * 自定义错误
     *
     * @param statusCodeEnum
     * @return com.liziczh.ddd.mesh.api.response.Result<T>
     * @author chenzhehao
     * @date 2022/1/16 9:47 下午
     */
    public static <T> Result<T> error(StatusCodeEnum statusCodeEnum) {
        return new Result<T>()
                .status(statusCodeEnum.getCode())
                .message(statusCodeEnum.getDesc());
    }

    /**
     * 自定义错误
     *
     * @author chenzhehao
     * @date 2021/12/10 11:12 下午
     */
    public static <T> Result<T> error(String status, String message) {
        return new Result<T>().status(status).message(message);
    }

}
