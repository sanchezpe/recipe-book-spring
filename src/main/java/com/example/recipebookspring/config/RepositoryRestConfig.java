package com.example.recipebookspring.config;

import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Component
@RequiredArgsConstructor
public class RepositoryRestConfig implements RepositoryRestConfigurer {
    private final AppConfigProperties appProperties;

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        cors
                .addMapping(appProperties.getCors().getMappingPathPattern())
                .allowedOrigins(appProperties.getCors().getAllowedOrigins().toArray(new String[0]))
                .allowedMethods(appProperties.getCors().getAllowedMethods().toArray(new String[0]))
                .allowedHeaders(appProperties.getCors().getAllowedHeaders().toArray(new String[0]))
        ;
    }
}
