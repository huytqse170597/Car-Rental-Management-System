package com.mss301.carservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/api/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/api/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/api/**").hasAuthority("ADMIN")
                .anyRequest().authenticated()
            )
            .csrf(csrf -> csrf.disable());
        return http.build();
    }
}
