package com.tumbler.springpractice.demo2;

import java.lang.annotation.*;

/**
 * @author gengweiweng
 * @time 2021/11/22
 * @desc
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE,ElementType.FIELD,ElementType.PARAMETER})
public @interface Mapper {
}
