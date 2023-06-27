package com.example.norepeatsubmit.annotation;

import java.lang.annotation.*;


/**
 * @author lichengcan
 * @description 业务接口回参处理注解类
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
public @interface ResponseResult {
}
