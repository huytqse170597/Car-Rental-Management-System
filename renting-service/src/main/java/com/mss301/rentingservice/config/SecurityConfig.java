package com.mss301.rentingservice.config;

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
                .requestMatchers(HttpMethod.POST, "/api/renting").hasAuthority("CUSTOMER")
                .requestMatchers(HttpMethod.GET, "/api/renting/history/**").hasAuthority("CUSTOMER")
                .requestMatchers(HttpMethod.GET, "/api/renting/report").hasAuthority("ADMIN")
                .anyRequest().authenticated()
            )
            .csrf(csrf -> csrf.disable());
        return http.build();
    }
}
