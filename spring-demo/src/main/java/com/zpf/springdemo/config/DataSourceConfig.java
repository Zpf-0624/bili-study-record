package com.zpf.springdemo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * archives:
 * JPA 多数据源
 * @date: 2022/5/22
 * @Author: Nicky.Zhang
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "dataSource")
    @Qualifier("dataSource")
    @QuartzDataSource
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.ga")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

}
