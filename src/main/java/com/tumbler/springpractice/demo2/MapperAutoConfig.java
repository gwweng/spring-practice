package com.tumbler.springpractice.demo2;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author gengweiweng
 * @time 2021/11/22
 * @desc
 */
@Configuration
@Import(MapperAutoConfiguredMyBatisRegistrar.class)
public class MapperAutoConfig {
}
