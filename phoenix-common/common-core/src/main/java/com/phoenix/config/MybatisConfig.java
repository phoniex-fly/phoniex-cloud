package com.phoenix.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis分页配置
 */
@Configuration
@MapperScan("com.phoenix.dao")
public class MybatisConfig {


}
