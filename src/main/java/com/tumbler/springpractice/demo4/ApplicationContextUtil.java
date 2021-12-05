package com.tumbler.springpractice.demo4;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author gengweiweng
 * @time 2021/12/5
 * @desc ApplicationContextAware接口会在
 */
@Component
public class ApplicationContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static Object getObject(String beanName){
        if(applicationContext == null){
            System.out.println("applicationcontext为空");
        }
        return applicationContext.getBean(beanName);
    }
}
