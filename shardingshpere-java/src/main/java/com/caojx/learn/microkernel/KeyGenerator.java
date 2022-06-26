package com.caojx.learn.microkernel;

/**
 * 定义自增键生成接口
 *
 * @author caojx created on 2022/6/25 5:08 PM
 */
public interface KeyGenerator {

    /**
     * 获取自增键
     *
     * @return
     */
    String getKey();
}
