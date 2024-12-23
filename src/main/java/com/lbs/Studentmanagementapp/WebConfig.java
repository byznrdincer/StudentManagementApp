package com.lbs.Studentmanagementapp;

import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class WebConfig {
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOriginPattern("http://127.0.0.1:*");  // Herhangi bir port için izin ver
        config.addAllowedMethod("*");  // Tüm HTTP metodlarına izin ver
        config.addAllowedHeader("*");  // Tüm başlıklara izin ver
        config.setAllowCredentials(true);  // Kimlik doğrulama gerekiyorsa true

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);  // Tüm endpoint'lere bu yapı uygulanacak
        return new CorsFilter(source);
    }
}
