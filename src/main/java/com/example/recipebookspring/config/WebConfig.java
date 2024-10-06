package com.example.recipebookspring.config;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
    private final AppConfigProperties appConfigProperties;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping(appConfigProperties.getCors().getMappingPathPattern())
                .allowedOrigins(appConfigProperties.getCors().getAllowedOrigins().toArray(new String[0]))
                .allowedMethods(appConfigProperties.getCors().getAllowedMethods().toArray(new String[0]))
                .allowedHeaders(appConfigProperties.getCors().getAllowedHeaders().toArray(new String[0]))
        ;
    }
}
