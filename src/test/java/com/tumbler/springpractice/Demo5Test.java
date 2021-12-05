package com.tumbler.springpractice;

import com.tumbler.springpractice.demo5.UserBean;
import com.tumbler.springpractice.demo4.ApplicationContextUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author gengweiweng
 * @time 2021/12/5
 * @desc
 */
public class Demo5Test extends SpringPracticeApplicationTests{


    @Autowired
    private UserBean userBean;

    @Test
    public void test(){
        System.out.println(userBean);
        Object bean = ApplicationContextUtil.getObject("&userFactoryBean");
        Object bean1 = ApplicationContextUtil.getObject("userFactoryBean");
        System.out.println(bean);
        System.out.println(bean1);
    }
}
