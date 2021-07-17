package com.liziczh.mesh.web.aop;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
@Documented
public @interface WebLogIgnore {
	String description() default "";
}
