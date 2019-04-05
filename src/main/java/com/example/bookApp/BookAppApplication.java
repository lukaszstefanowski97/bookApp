package com.example.bookApp;

import com.example.bookApp.config.WebSecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class BookAppApplication {

    WebSecurityConfig webSecurityConfig;

    public static void main(String[] args) {
        SpringApplication.run(BookAppApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/books").allowedOrigins("http://localhost:3000");
                registry.addMapping("/add/addBook").allowedOrigins("http://localhost:3000");
            }
        };
    }
}
