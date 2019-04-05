package com.example.bookApp.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public interface WebSecurityConfig {

    void configure(HttpSecurity http) throws Exception;
}
