package com.tumbler.springpractice.demo1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author gengweiweng
 * @time 2021/11/22
 * @desc
 */
@Configuration
@ComponentScan("com.tumbler.springpractice.demo1")
@Import(HelloImportBeanDefinitionRegistrar.class)
public class HelloConfig {

}
