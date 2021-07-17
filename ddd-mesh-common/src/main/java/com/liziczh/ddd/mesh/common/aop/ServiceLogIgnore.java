package com.liziczh.ddd.mesh.common.aop;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface ServiceLogIgnore {
    String description() default "";
}