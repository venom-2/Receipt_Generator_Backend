package com.receipt.generator.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CORSConfiguration {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        config.addAllowedOriginPattern("*"); // Allow all origins
        config.addAllowedHeader("*");        // Allow all headers
        config.addAllowedMethod("*");        // Allow all HTTP methods (GET, POST, PUT, DELETE, etc.)
        config.setAllowCredentials(true);    // Allow credentials (e.g., cookies, authorization headers)

        source.registerCorsConfiguration("/**", config); // Apply CORS configuration to all endpoints
        return new CorsFilter(source);
    }
}
