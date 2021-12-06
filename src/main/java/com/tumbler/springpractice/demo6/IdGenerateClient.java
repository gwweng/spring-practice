package com.tumbler.springpractice.demo6;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author gengweiweng
 * @time 2021/12/6
 * @desc 生成器属性注解，用于判断是否需要注入属性对象
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
public @interface IdGenerateClient {
    // ID生成器名称
    String value() default "DEFAULT";
}
