package com.caojx.learn.microkernel;

/**
 * 基于雪花算法
 *
 * @author caojx created on 2022/6/25 5:10 PM
 */
public class SnowflakeKeyGenerator implements KeyGenerator {
    @Override
    public String getKey() {
        // 具体实现略
        return "SnowflakeKey";
    }
}
