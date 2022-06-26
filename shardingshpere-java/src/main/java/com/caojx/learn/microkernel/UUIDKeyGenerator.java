package com.caojx.learn.microkernel;

/**
 * UUID
 *
 * @author caojx created on 2022/6/25 5:09 PM
 */
public class UUIDKeyGenerator implements KeyGenerator {
    @Override
    public String getKey() {
        // 具体实现略
        return "UUIDKey";
    }
}
