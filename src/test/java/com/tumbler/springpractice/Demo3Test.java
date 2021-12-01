package com.tumbler.springpractice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author gengweiweng
 * @time 2021/12/1
 * @desc
 */
public class Demo3Test extends SpringPracticeApplicationTests {

    @Value("${customize.property.message}")
    private String message;

    @Test
    public void test(){
        System.out.printf(message);
    }
}
