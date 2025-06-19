package com.mss301.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DocConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("auth-service", r -> r.path("/api/auth/**")
                        .filters(f -> f.stripPrefix(2)
                                .addRequestHeader("X-Auth-Service", "AuthServiceHeaderValue"))
                        .uri("http://localhost:8081"))
                .route("car-service", r -> r.path("/api/car/**")
                        .filters(f -> f.stripPrefix(2)
                                .addRequestHeader("X-Car-Service", "CarServiceHeaderValue"))
                        .uri("http://localhost:8082"))
                .route("renting-service", r -> r.path("/api/renting/**")
                        .filters(f -> f.stripPrefix(2)
                                .addRequestHeader("X-Renting-Service", "RentingServiceHeaderValue"))
                        .uri("http://localhost:8083"))
                .build();
    }
}

