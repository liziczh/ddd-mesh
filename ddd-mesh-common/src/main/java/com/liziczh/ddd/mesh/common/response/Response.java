package com.liziczh.ddd.mesh.common.response;

import lombok.Data;

/**
 * 响应体
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2021/12/10 11:06 下午
 */
@Data
public class Response<T> {

    /**
     * 状态码
     */
    private String status;

    /**
     * 状态信息
     */
    private String message;

    /**
     * 数据
     */
    private T data;

    /**
     * 状态码
     *
     * @param status
     * @return com.liziczh.ddd.mesh.common.response.Response<T>
     * @author chenzhehao
     * @date 2022/1/16 9:44 下午
     */
    public Response<T> status(String status) {
        this.status = status;
        return this;
    }

    /**
     * 状态信息
     *
     * @param message
     * @return com.liziczh.ddd.mesh.common.response.Response<T>
     * @author chenzhehao
     * @date 2022/1/16 9:44 下午
     */
    public Response<T> message(String message) {
        this.message = message;
        return this;
    }

    /**
     * 响应数据
     *
     * @param data
     * @return com.liziczh.ddd.mesh.common.response.Response<T>
     * @author chenzhehao
     * @date 2022/1/16 9:45 下午
     */
    public Response<T> data(T data) {
        this.data = data;
        return this;
    }

}
