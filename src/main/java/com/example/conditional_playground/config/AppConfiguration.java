package com.example.conditional_playground.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@EnableConfigurationProperties(AppProperties.class)
public class AppConfiguration {
//    @Bean
//    public String appInfo(AppProperties properties) {
//        System.out.println("JWT Secret: " + properties.getJwt().getSecret());
//        System.out.println("JWT Expiry: " + properties.getJwt().getExpiry());
//        System.out.println("Audit Enabled: " + properties.getAudit().isEnabled());
//        System.out.println("Audit Table: " + properties.getAudit().getTable());
//        return "appInfo";
//    }
}
