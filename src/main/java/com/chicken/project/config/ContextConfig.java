package com.chicken.project.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
@ComponentScan(basePackages = "com.chicken.project")
public class ContextConfig {

    @Bean    public MessageSource messageSource(){

        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:/message/message");
        messageSource.setDefaultEncoding("UTF-8");

        return messageSource;
    }
}
