package com.tumbler.springpractice.demo6;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

/**
 * @author gengweiweng
 * @time 2021/12/6
 * @desc 使用SpringBoot的starter开发的ID生成器，虽然简单但是缺乏使用方自定义入口
 * 在不同业务下如果想要分组生成，则使用BeanPostProcessor会更加灵活
 */
@Component
public class IdGeneratorBeanPostProcessor implements BeanPostProcessor {
    /***
     * Spring中Bean的实例化过程
     * 1.实例化Bean对象
     * 2.设置对象属性
     * 3.检查Aware相关接口并设置相关依赖
     * 4.BeanPostProcessor前置处理
     * 5.检查是否是InitializingBean以决定是否调用afterPropertiesSet方法
     * 6.检查是否配置有自定义的init-method
     * 7.BeanPostProcessor后置处理
     * 8.注册必要的Destruction相关回调接口
     * 9.使用中
     * 10.是否实现DisposableBean接口
     * 11.是否配置自定义的destroy方法
     */


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        parseFields(bean);
        return bean;
    }

    private void parseFields(final Object bean) {
        if (bean == null) {
            return;
        }
        Class<?> beanClass = bean.getClass();
        parseFields(bean, beanClass);
        while (beanClass.getSuperclass() != null && !beanClass.getSuperclass().equals(Object.class)){
            beanClass = beanClass.getSuperclass();
            parseFields(bean, beanClass);
        }
    }

    private void parseFields(final Object bean, Class<?> clazz){
        if(bean == null || clazz == null){
            return;
        }
        for (Field field : clazz.getDeclaredFields()){
            try {
                IdGenerateClient anno = AnnotationUtils.getAnnotation(field, IdGenerateClient.class);
                if (anno == null){
                    continue;
                }
                String groupName = anno.value();
                Class<?> type = field.getType();
                if(type.equals(IdGenerator.class)){
                    IdGenerator idGenerator = IdGeneratorFactory.INSTANCE.create(groupName);
                    invokeSetField(bean, field, idGenerator);
                    continue;
                }
                throw new RuntimeException("未知字段类型无法初始化,bean: " + bean + ", field: "+ field);
            } catch (Throwable e) {
                throw new RuntimeException("初始化字段失败，bean= "+ bean + ", field=" + field, e);
            }
        }
    }

    private void invokeSetField(Object bean, Field field, Object param){
        // 设置属性可访问
        ReflectionUtils.makeAccessible(field);
        // 在指定对象bean中给指定字段field设置指定值param
        ReflectionUtils.setField(field, bean, param);
    }
}
