package com.tumbler.springpractice.demo5;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author gengweiweng
 * @time 2021/12/5
 * @desc 工厂Bean，可以自定义创建Bean的过程，而BeanFactory则是一个容器，负责管理和创建Bean
 * 使用"userFactoryBean"作为beanName可以获取getObject返回的Bean
 * 使用"&userFactoryBean"可以获取到工厂Bean本身
 */
@Component
public class UserFactoryBean implements FactoryBean<UserBean> {
    @Override
    public UserBean getObject() throws Exception {
        System.out.println("UserFactoryBean的getBean方法被调用");
        return new UserBean();
    }

    @Override
    public Class<?> getObjectType() {
        return UserBean.class;
    }
}
