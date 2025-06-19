package com.mss301.rentingservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Renting Service API")
                        .version("1.0")
                        .description("API documentation for Renting Service"));
    }

    @Bean
    public GroupedOpenApi rentingServiceApi() {
        return GroupedOpenApi.builder()
                .group("renting-service")
                .pathsToMatch("/api/**")
                .build();
    }
}
