package com.hgf.controla.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * created by hgf
 * created time is 2019/11/25
 */

public class Raonfiguration {
    @Bean
    public KeyResolver pathKeyResolver() {
        return exchange -> Mono.just(
                exchange.getRequest()
                        .getPath()
                        .toString()
        );
    }
}
