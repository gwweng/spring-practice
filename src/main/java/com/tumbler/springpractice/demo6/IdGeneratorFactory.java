package com.tumbler.springpractice.demo6;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author gengweiweng
 * @time 2021/12/6
 * @desc 使用工厂单例类创建ID生成器，也可以使用SPI
 */

public enum IdGeneratorFactory {
    INSTANCE;

    private static final Map<String, IdGenerator> ID_GENERATOR_MAP = new ConcurrentHashMap<>(new HashMap<>());

    public synchronized IdGenerator create(String groupName) {
        return ID_GENERATOR_MAP.computeIfAbsent(groupName , key -> new DefaultIdGenerator(groupName));
    }
}
