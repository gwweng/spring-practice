package com.tumbler.springpractice.demo2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author gengweiweng
 * @time 2021/11/22
 * @desc
 */
public class MapperAutoConfiguredMyBatisRegistrar implements ImportBeanDefinitionRegistrar, ResourceLoaderAware {


    private ResourceLoader resourceLoader;


    /**
     * 借助扫描器（ClassPathBeanDefinitionScanner）扫描注册的bean
     * @param importingClassMetadata
     * @param registry
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        MyClasssPathBeanDefinitionScanner scanner = new MyClasssPathBeanDefinitionScanner(registry, false);
        scanner.setResourceLoader(resourceLoader);
        scanner.registerDefaultFilters();
        scanner.doScan("com.tumbler.springpractice.demo2");
    }


    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }


}
