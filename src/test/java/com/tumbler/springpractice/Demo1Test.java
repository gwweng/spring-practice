package com.tumbler.springpractice;

import com.tumbler.springpractice.demo1.HelloConfig;
import com.tumbler.springpractice.demo1.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author gengweiweng
 * @time 2021/11/22
 * @desc
 */
@ContextConfiguration(classes = {HelloConfig.class})
public class Demo1Test extends SpringPracticeApplicationTests{


    @Autowired
    private HelloService helloService;

    @Test
    public void testDemo1(){
        System.out.println(helloService.getClass().getName());
    }
}
