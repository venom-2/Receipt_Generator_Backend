package com.receipt.generator.configuration;

import com.receipt.generator.filter.TokenValidationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    private final TokenValidationFilter tokenValidationFilter;

    // Constructor injection for the filter
    public FilterConfig(TokenValidationFilter tokenValidationFilter) {
        this.tokenValidationFilter = tokenValidationFilter;
    }

    @Bean
    public FilterRegistrationBean<TokenValidationFilter> loggingFilter() {
        FilterRegistrationBean<TokenValidationFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(tokenValidationFilter); // Use the Spring-managed filter bean
        registrationBean.addUrlPatterns("/api/receipt/*");
        return registrationBean;
    }
}
