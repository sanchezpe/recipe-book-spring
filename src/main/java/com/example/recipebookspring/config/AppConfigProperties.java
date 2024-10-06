package com.example.recipebookspring.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.List;

@Component
@ConfigurationProperties("app")
@Getter
@Setter
public class AppConfigProperties {
    @NestedConfigurationProperty
    private CorsProperties cors = new CorsProperties();

    @NestedConfigurationProperty
    private KeyPairProperties keyPair;
}

@Getter
@Setter
class CorsProperties {
    private String mappingPathPattern;
    private List<String> allowedOrigins;
    private List<String> allowedMethods;
    private List<String> allowedHeaders;
}

record KeyPairProperties(
        RSAPrivateKey privateKey,
        RSAPublicKey publicKey
) {
}
