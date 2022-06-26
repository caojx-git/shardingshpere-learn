package com.caojx.learn.utils;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shardingsphere.api.config.sharding.KeyGeneratorConfiguration;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.strategy.InlineShardingStrategyConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * DataSourceUtil 用于获取HikariDataSource
 *
 * @author caojx created on 2022/6/23 3:17 PM
 */
public class DataSourceUtil {

    private static final String HOST = "localhost";
    private static final int PORT = 3306;
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";

    /**
     * 创建数据源
     *
     * @param dataSourceName
     * @return
     */
    public static DataSource createDataSource(final String dataSourceName) {
        DruidDataSource result = new DruidDataSource();
        result.setDriverClassName(com.mysql.jdbc.Driver.class.getName());
        result.setUrl(String.format("jdbc:mysql://%s:%s/%s?serverTimeZone=UTC&useSSL=false&userUnicode=true&characterEncoding=UTF-8", HOST, PORT, dataSourceName));
        result.setUsername(USER_NAME);
        result.setPassword(PASSWORD);
        return result;
    }

    /**
     * 数据源集合
     * 使用Map来保存两个数据源对象
     *
     * @return
     */
    private static Map<String, DataSource> createDataSourceMap() {
        Map<String, DataSource> result = new HashMap<>();
        result.put("ds0", DataSourceUtil.createDataSource("ds0"));
        result.put("ds1", DataSourceUtil.createDataSource("ds1"));
        return result;
    }

    /**
     * 通过分库分表规则来获取目标DataSource
     *
     * @return
     * @throws Exception
     */
    public DataSource dataSource() throws Exception {
        // 创建分片规则配置类
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();

        // 创建分表规则配置类
        TableRuleConfiguration tableRuleConfig = new TableRuleConfiguration("user", "ds${0..1}.user${0..1}");

        // 创建分布式主键生成配置类
        Properties properties = new Properties();
        properties.setProperty("worker.id", "33");
        KeyGeneratorConfiguration keyGeneratorConfig = new KeyGeneratorConfiguration("SNOWFLAKE", "id", properties);
        tableRuleConfig.setKeyGeneratorConfig(keyGeneratorConfig);

        shardingRuleConfig.getTableRuleConfigs().add(tableRuleConfig);

        // 根据年龄分库，一共分为2个库
        shardingRuleConfig.setDefaultDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("age", "ds${age%2}"));

        // 根据用户id分表，一共分为2张表
        shardingRuleConfig.setDefaultTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("id", "user${id%2}"));

        // 通过工厂类创建具体的DataSource
        return ShardingDataSourceFactory.createDataSource(createDataSourceMap(), shardingRuleConfig, new Properties());

    }

}
