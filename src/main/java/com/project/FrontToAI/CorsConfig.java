package com.project.FrontToAI;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/*")
                .allowedOrigins("https://kayas1.github.io/ai-insect-inspection") // 리액트 애플리케이션의 주소
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("");
    }
}