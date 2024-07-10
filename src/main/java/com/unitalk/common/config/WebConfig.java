package com.unitalk.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // /uploads/program/** 경로의 요청을 사용자 홈 디렉터리 내 unitalk/uploads/program/ 디렉터리로 매핑
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploads/program/**")
                .addResourceLocations("file:" + System.getProperty("user.home") + "/unitalk/uploads/program/");
    }
}
