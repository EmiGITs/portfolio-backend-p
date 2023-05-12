package com.emilianodri.portfoliobackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/login")
                                .allowedOrigins("https://portfolio-frontend-2ae4b.web.app")
                                        .allowedMethods("*")
                                                .exposedHeaders("*");

               registry.addMapping("/api/**")
                .allowedOrigins("https://portfolio-frontend-2ae4b.web.app")
                       .allowedMethods("*");

                registry.addMapping("/media/**")
                        .allowedOrigins("https://portfolio-frontend-2ae4b.web.app")
                        .allowedMethods("*");
            }
        };
    }
}
