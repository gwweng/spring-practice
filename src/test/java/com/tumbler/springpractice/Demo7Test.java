package com.tumbler.springpractice;

import com.tumbler.springpractice.demo7.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author gengweiweng
 * @time 2021/12/28
 * @desc
 */
public class Demo7Test extends SpringPracticeApplicationTests{

    @Autowired
    private User user;

    @Test
    public void test() {
        System.out.println(user.getClass().getName());
    }
}
