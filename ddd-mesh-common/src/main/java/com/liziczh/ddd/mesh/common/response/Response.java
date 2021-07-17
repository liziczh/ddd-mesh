package com.liziczh.ddd.mesh.common.response;

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
public class Response<T> implements Serializable {

    private static final long serialVersionUID = -149250316051709651L;

    private String code;

    private String msg;

    private T data;

    public Response<T> code(String code) {
        this.code = code;
        return this;
    }

    public Response<T> msg(String msg) {
        this.msg = msg;
        return this;
    }

    public Response<T> data(T data) {
        this.data = data;
        return this;
    }

    /**
     * 通用操作成功
     *
     * @author chenzhehao
     * @date 2021/7/17 21:59
     */
    public static <T> Response<T> success() {
        return new Response<T>().code(RESPONSE_CODE.SUCCESS.getCode()).msg(RESPONSE_CODE.SUCCESS.getMsg());
    }

    /**
     * 通用操作成功
     *
     * @author chenzhehao
     * @date 2021/7/17 21:59
     */
    public static <T> Response<T> success(String msg) {
        return new Response<T>().code(RESPONSE_CODE.SUCCESS.getCode()).msg(msg);
    }

    /**
     * 通用操作成功
     *
     * @author chenzhehao
     * @date 2021/7/17 21:59
     */
    public static <T> Response<T> success(T data) {
        return new Response<T>().code(RESPONSE_CODE.SUCCESS.getCode()).msg(RESPONSE_CODE.SUCCESS.getMsg()).data(data);
    }

    /**
     * 通用操作成功
     *
     * @author chenzhehao
     * @date 2021/7/17 21:59
     */
    public static <T> Response<T> success(String msg, T data) {
        return new Response<T>().code(RESPONSE_CODE.SUCCESS.getCode()).msg(msg).data(data);
    }

    /**
     * 通用系统错误
     *
     * @author chenzhehao
     * @date 2021/7/17 22:03
     */
    public static <T> Response<T> error() {
        return new Response<T>().code(RESPONSE_CODE.ERROR.getCode()).msg(RESPONSE_CODE.ERROR.getMsg());
    }

    /**
     * 通用系统错误
     *
     * @author chenzhehao
     * @date 2021/7/17 22:03
     */
    public static <T> Response<T> error(String code, String msg) {
        return new Response<T>().code(code).msg(msg);
    }

    /**
     * 自行构建
     *
     * @author chenzhehao
     * @date 2021/7/17 22:03
     */
    public static <T> Response<T> build() {
        return new Response<T>();
    }

    /**
     * 请求响应状态码
     */
    public enum RESPONSE_CODE {
        SUCCESS("200", "操作成功"),
        ERROR("500", "系统错误"),
        FAILED("700", "操作失败");

        private String code;
        private String msg;

        RESPONSE_CODE(String code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public String getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }
}
