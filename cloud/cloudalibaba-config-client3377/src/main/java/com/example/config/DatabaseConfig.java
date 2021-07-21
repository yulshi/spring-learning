package com.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@RefreshScope
public class DatabaseConfig {

    @Bean
    @ConfigurationProperties(prefix = "db")
    public DataSource dataSourceForPostgresql() {
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }


}
