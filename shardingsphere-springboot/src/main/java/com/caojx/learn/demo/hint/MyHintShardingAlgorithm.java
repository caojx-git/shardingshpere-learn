package com.caojx.learn.demo.hint;

import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 自定义Hint路由策略，实现HintShardingAlgorithm接口
 *
 * @author caojx created on 2022/6/27 9:43 PM
 */
public final class MyHintShardingAlgorithm implements HintShardingAlgorithm<Integer> {

    /**
     * @param availableTargetNames 代表：分片目标，即数据库、表分片。如果是对分库路由，表示ds0，ds1；
     * @param shardingValue        代表：分片值; 可以HintManager设置多个分片值，所以是个集合。
     * @return
     */
    @Override
    public Collection<String> doSharding(final Collection<String> availableTargetNames, final HintShardingValue<Integer> shardingValue) {
        Collection<String> result = new ArrayList<>();
        for (String each : availableTargetNames) {
            for (Integer value : shardingValue.getValues()) {
                if (each.endsWith(String.valueOf(value))) {
                    result.add(each);
                }
            }
        }
        return result;
    }
}
