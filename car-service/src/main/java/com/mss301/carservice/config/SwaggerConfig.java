package com.mss301.carservice.config;

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
                        .title("Car Service API")
                        .version("1.0")
                        .description("API documentation for Car Service"));
    }

    @Bean
    public GroupedOpenApi carServiceApi() {
        return GroupedOpenApi.builder()
                .group("car-service")
                .pathsToMatch("/api/**")
                .build();
    }
}
