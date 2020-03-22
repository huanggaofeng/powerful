package com.hgf.controla.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

/**
 * created by hgf
 * created time is 2020/2/21
 */
@Configuration
public class RouteLocatorConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes().route(r -> r.path("/user/**")
                .filters(f -> {
                    f.filter(new GatewayRateLimitFilterByIP(1, 1, Duration.ofSeconds(1)));
                    f.stripPrefix(1);
                    f.hystrix(config -> config.setFallbackUri("forward:/userFallBack").setName("fallbackcmd"));
                    return f;
                })
                .uri("lb://user").order(0).id("user-service")).build();
    }
}
