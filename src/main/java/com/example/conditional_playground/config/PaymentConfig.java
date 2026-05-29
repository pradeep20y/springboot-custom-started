package com.example.conditional_playground.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentConfig {

    @Bean
    @ConditionalOnProperty(
            name = "payment.enables",
            havingValue = "true",
            matchIfMissing = false

    )
    public String paymentService() {
        System.out.println("Payment has been created");
        return "payment success";
    }

//    @Bean
//    public String jwtFilter() {
//        System.out.println("CUSTOM jwt filter created by developer");
//        return "CustomJwtFilter";
//    }
//
//    @Bean
//    @ConditionalOnMissingBean(name = "jwtFilter")
//    public String defaultJwtFilter() {
//        System.out.println("defaultJwtFilter has been created");
//        return "Default JWT filter created successfully";
//    }

    @Bean
    @ConditionalOnClass(name = "com.mysql.cj.jdbc.Driver")
    public String databaseOptimizer() {
        System.out.println("MySQL detected — database optimizer created");
        return "MySQLOptimizer";
    }

}
