package com.liziczh.ddd.mesh.common.aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import com.liziczh.ddd.mesh.common.util.JsonUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * common
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2021/7/17 21:52
 */
@Slf4j
@Component
@Aspect
public abstract class BaseErrorMailAop {

    @Pointcut("execution(public * com.liziczh..*.*(..))")
    public void serviceException() {
    }

    /**
     * 异常通知
     *
     * @param joinPoint 切入点
     * @param exception 异常
     */
    @AfterThrowing(value = "serviceException()", throwing = "exception")
    public void handleThrowing(JoinPoint joinPoint, Exception exception) {
        // ErrorMailIgnore
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        ErrorMailIgnore errorMailIgnore = AnnotationUtils.findAnnotation(methodSignature.getMethod(), ErrorMailIgnore.class);
        if (errorMailIgnore != null) {
            return;
        }
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        try {
            this.sendErrorMessage(exception, className, methodName, JsonUtils.toJson(args), new Date());
        } catch (Exception e) {
            log.debug(e.getMessage(), e);
        }
    }

    /**
     * 发送异常邮件
     *
     * @param exception    异常
     * @param className    类名
     * @param methodName   方法名
     * @param methodParams 方法参数
     * @param occurTime    异常发生时间
     */
    protected abstract void sendErrorMessage(Exception exception, String className, String methodName, String methodParams, Date occurTime);
}
