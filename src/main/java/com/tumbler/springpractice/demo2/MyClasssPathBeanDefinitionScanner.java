package com.tumbler.springpractice.demo2;

import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.Set;

/**
 * 通过扫描器来获取我们需要注册的bean
 * @author gengweiweng
 * @time 2021/11/22
 * @desc
 */
public class MyClasssPathBeanDefinitionScanner extends ClassPathBeanDefinitionScanner {
    public MyClasssPathBeanDefinitionScanner(BeanDefinitionRegistry registry, boolean useDefaultFilters) {
        super(registry, useDefaultFilters);
    }

    /**
     * @Author haien
     * @Description 注册条件过滤器，将@Mapper注解加入允许扫描的过滤器中，
     * 如果加入排除扫描的过滤器集合excludeFilter中，则不会扫描
     * @Date 2019/6/11
     * @Param []
     * @return void
     **/
    @Override
    protected void registerDefaultFilters() {
        addIncludeFilter(new AnnotationTypeFilter(Mapper.class));
    }



    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        return super.doScan(basePackages);
    }
}
