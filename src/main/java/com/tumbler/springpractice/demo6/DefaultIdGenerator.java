package com.tumbler.springpractice.demo6;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author gengweiweng
 * @time 2021/12/6
 * @desc 使用AtomicLong模拟自增， 同时考虑ID生成器是分组的，使用ConcurrentHashMap实现ID生成器的持有
 */
public class DefaultIdGenerator implements IdGenerator{

    private static final Map<String, AtomicLong> ID_POOL = new ConcurrentHashMap<>(new HashMap<>());

    private final String groupName;

    public DefaultIdGenerator(String groupName) {
        this.groupName = groupName;
        synchronized (ID_POOL) {
            ID_POOL.computeIfAbsent(groupName, key -> new AtomicLong(1));
        }
    }

    @Override
    public String groupName() {
        return this.groupName;
    }

    @Override
    public long nextId() {
        return ID_POOL.get(this.groupName).getAndIncrement();
    }
}
