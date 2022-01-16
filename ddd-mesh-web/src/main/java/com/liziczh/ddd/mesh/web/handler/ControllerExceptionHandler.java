package com.liziczh.ddd.mesh.web.handler;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.liziczh.ddd.mesh.api.response.Result;
import com.liziczh.ddd.mesh.common.enums.StatusCodeEnum;
import com.liziczh.ddd.mesh.common.exception.BizErrorException;
import com.liziczh.ddd.mesh.common.exception.BizInfoException;
import com.liziczh.ddd.mesh.common.exception.BizWarnException;
import com.liziczh.ddd.mesh.common.util.JsonUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * Controller异常转换
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2022/1/16 12:50 下午
 */
@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(BizInfoException.class)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public Result<Void> handleBizInfoException(BizInfoException e) {
        return buildResponse(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(BizWarnException.class)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public Result<Void> handleBizErrorException(BizWarnException e) {
        return buildResponse(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(BizErrorException.class)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public Result<Void> handleBizErrorException(BizErrorException e) {
        return buildResponse(e.getCode(), e.getMessage());
    }

    /**
     * 构建异常错误响应信息
     *
     * @param code
     * @param message
     * @return com.liziczh.ddd.mesh.api.response.Result<java.lang.Void>
     * @author chenzhehao
     * @date 2022/1/16 10:10 下午
     */
    private Result<Void> buildResponse(String code, String message) {
        Result<Void> result = new Result<>()
                .status(StringUtils.isBlank(code) ? StatusCodeEnum.ERROR.getCode() : code)
                .message(StringUtils.isBlank(message) ? StatusCodeEnum.ERROR.getDesc() : message));
        log.info("exception error：{}", JsonUtils.toJson(result));
        return result;
    }
}
