package com.tech.watergallery.config;

import org.apache.ibatis.type.TypeHandlerRegistry;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisConfig {
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return configuration -> {
            TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
        };
    }
}
