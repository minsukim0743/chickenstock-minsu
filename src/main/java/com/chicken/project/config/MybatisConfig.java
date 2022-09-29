package com.chicken.project.config;

import org.apache.ibatis.annotations.Mapper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.chicken.project", annotationClass = Mapper.class )
public class MybatisConfig {

}
