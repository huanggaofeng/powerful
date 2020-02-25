package com.hgf.controla.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * created by hgf
 * created time is 2019/11/11
 */
public class HostAddrKeyResolver implements KeyResolver {
    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {

        return Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
    }
}
