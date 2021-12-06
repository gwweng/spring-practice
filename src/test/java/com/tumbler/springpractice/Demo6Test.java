package com.tumbler.springpractice;

import com.tumbler.springpractice.demo6.IdGenerateClient;
import com.tumbler.springpractice.demo6.IdGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

/**
 * @author gengweiweng
 * @time 2021/12/6
 * @desc
 */
public class Demo6Test extends SpringPracticeApplicationTests{

    @IdGenerateClient(value = "group1")
    private IdGenerator group1;

    @IdGenerateClient(value = "group2")
    private IdGenerator group2;

    @IdGenerateClient(value = "group2")
    private IdGenerator group3;

    @Test
    void testId() {
        Assert.notNull(group1, "group1注入失败");
        Assert.notNull(group2, "group2注入失败");
        System.out.println(group1.groupName() + " ==>" + group1.nextId());
        for (int i=0 ; i<5 ; i++){
            System.out.println(group1.groupName() + " ==>" + group1.nextId());
            System.out.println(group2.groupName() + " ==>" + group2.nextId());
            System.out.println(group3.groupName() + " ==>" + group3.nextId());
        }
    }
}
