package com.example.conditional_playground.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(name = "io.jsonwebtoken.Jwts")
@ConditionalOnProperty(
        name = "myapp.jwt.enabled",
        havingValue = "true",
        matchIfMissing = false
)
public class SecurityAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(name = "jwtFilter")
    public String jwtFilter(AppProperties properties) {
        System.out.println("JWT filter created");
        System.out.println("Secret: " + properties.getJwt().getSecret());
        System.out.println("Expiry: " + properties.getJwt().getExpiry());
        return "DefaultJwtFilter";
    }

}
