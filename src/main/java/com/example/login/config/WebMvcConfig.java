package com.example.login.config;


import jdk.internal.instrumentation.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import lombok.extern.slf4j.Slf4j;
@Configuration
    public class WebMvcConfig extends WebMvcConfigurationSupport {

        @Override
        protected void addResourceHandlers(ResourceHandlerRegistry registry) {

            System.out.println("开始进行静态资源映射");

            registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        }

    }

