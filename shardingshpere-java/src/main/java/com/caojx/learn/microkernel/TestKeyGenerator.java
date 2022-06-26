package com.caojx.learn.microkernel;

import java.util.ServiceLoader;

/**
 * 基于JDK的微内核模式，加载实例
 *
 * @author caojx created on 2022/6/25 5:16 PM
 */
public class TestKeyGenerator {

    public static void main(String[] args) {
        ServiceLoader<KeyGenerator> generators = ServiceLoader.load(KeyGenerator.class);

        for (KeyGenerator generator : generators) {
            System.out.println(generator.getClass());
            System.out.println(generator.getKey());
        }
    }
}
