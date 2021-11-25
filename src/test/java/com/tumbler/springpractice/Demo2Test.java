package com.tumbler.springpractice;

import com.tumbler.springpractice.demo2.CountryMapper;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author gengweiweng
 * @time 2021/11/22
 * @desc
 */
@ContextConfiguration(classes = {})
public class Demo2Test extends SpringPracticeApplicationTests{
    @Resource
    CountryMapper countryMapper;


    @Test
    void contextLoads(){
        assertNotNull(countryMapper);
        System.out.println(countryMapper.getClass().getName());
    }
}
