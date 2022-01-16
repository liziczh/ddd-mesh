package com.liziczh.ddd.mesh.common.response;

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
public class ResponseBuilder<T> {

    /**
     * 通用操作成功
     *
     * @param
     * @return com.liziczh.ddd.mesh.common.response.Response<T>
     * @author chenzhehao
     * @date 2022/1/16 9:47 下午
     */
    public static <T> Response<T> success() {
        return new Response<T>()
                .status(StatusCodeEnum.SUCCESS.getCode())
                .message(StatusCodeEnum.SUCCESS.getDesc());
    }

    /**
     * 通用操作成功
     *
     * @param data
     * @return com.liziczh.ddd.mesh.common.response.Response<T>
     * @author chenzhehao
     * @date 2022/1/16 9:47 下午
     */
    public static <T> Response<T> success(T data) {
        return new Response<T>()
                .status(StatusCodeEnum.SUCCESS.getCode())
                .message(StatusCodeEnum.SUCCESS.getDesc())
                .data(data);
    }

    /**
     * 通用系统错误
     *
     * @param
     * @return com.liziczh.ddd.mesh.common.response.Response<T>
     * @author chenzhehao
     * @date 2022/1/16 9:47 下午
     */
    public static <T> Response<T> error() {
        return new Response<T>()
                .status(StatusCodeEnum.ERROR.getCode())
                .message(StatusCodeEnum.ERROR.getDesc());
    }

    /**
     * 自定义错误
     *
     * @param statusCodeEnum
     * @return com.liziczh.ddd.mesh.common.response.Response<T>
     * @author chenzhehao
     * @date 2022/1/16 9:47 下午
     */
    public static <T> Response<T> error(StatusCodeEnum statusCodeEnum) {
        return new Response<T>()
                .status(statusCodeEnum.getCode())
                .message(statusCodeEnum.getDesc());
    }

    /**
     * 自定义错误
     *
     * @author chenzhehao
     * @date 2021/12/10 11:12 下午
     */
    public static <T> Response<T> error(String status, String message) {
        return new Response<T>().status(status).message(message);
    }

}
