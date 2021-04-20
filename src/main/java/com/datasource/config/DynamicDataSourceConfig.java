/**
 * Copyright (c) 2018 湖南神雀网络科技有限公司 All rights reserved.
 * <p>
 * www.sqqmall.com
 * <p>
 * 版权所有，侵权必究！
 */

package com.datasource.config;

import com.alibaba.druid.pool.DruidDataSource;

import com.datasource.properties.DataSourceProperties;
import com.datasource.properties.DynamicDataSourceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 配置多数据源
 *
 * @author Mark Wenjunchi
 */
@Configuration
@EnableConfigurationProperties(DynamicDataSourceProperties.class)
public class DynamicDataSourceConfig {
    @Autowired
    private DynamicDataSourceProperties properties;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid.base")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }


    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid.customer")
    public DataSourceProperties customerDataSource() {
        return new DataSourceProperties();
    }


    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid.dm")
    public DataSourceProperties dmDataSource() {
        return new DataSourceProperties();
    }

    @Bean
    public DynamicDataSource dynamicDataSource(@Qualifier("dataSourceProperties") DataSourceProperties dataSourceProperties,
                                               @Qualifier("customerDataSource")
                                                       DataSourceProperties customerDataSource,
                                               @Qualifier("dmDataSource")
                                                       DataSourceProperties dmDataSource) {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object, Object> map = getDynamicDataSource();
        map.put("customerDataSource", DynamicDataSourceFactory.buildDruidDataSource(customerDataSource));
        map.put("dmDataSource", DynamicDataSourceFactory.buildDruidDataSource(dmDataSource));
        dynamicDataSource.setTargetDataSources(map);
        // 默认数据源
        DruidDataSource defaultDataSource = DynamicDataSourceFactory.buildDruidDataSource(dataSourceProperties);
        dynamicDataSource.setDefaultTargetDataSource(defaultDataSource);

        return dynamicDataSource;
    }

    private Map<Object, Object> getDynamicDataSource() {
        Map<String, DataSourceProperties> dataSourcePropertiesMap = properties.getDatasource();
        Map<Object, Object> targetDataSources = new HashMap<>(dataSourcePropertiesMap.size());
        dataSourcePropertiesMap.forEach((k, v) -> {
            DruidDataSource druidDataSource = DynamicDataSourceFactory.buildDruidDataSource(v);
            targetDataSources.put(k, druidDataSource);
        });

        return targetDataSources;
    }

}