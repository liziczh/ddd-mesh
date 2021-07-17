package com.liziczh.ddd.mesh.application.aop;

import com.liziczh.base.common.aop.BaseExceptionMailAop;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
@Aspect
public class ExceptionMailAop extends BaseExceptionMailAop {
    @Override
    protected void sendErrorMessage(Exception exception, String className, String methodName, String methodParams, Date occurTime) {
    }
}
