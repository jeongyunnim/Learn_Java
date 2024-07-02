package msa.example.scgactuator.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {
    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user", r -> r.path("/user/**")
                        .uri("lb://user"))
                .route("board", r -> r.path("/board/**")
                        .uri("http://localhost:8082"))
                .build();
    }
}
