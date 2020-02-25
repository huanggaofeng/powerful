package com.hgf.controla;

import com.hgf.controla.config.HostAddrKeyResolver;
import com.hgf.controla.config.UriKeyResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

@SpringBootApplication
// 注册到服务中心
@EnableDiscoveryClient
public class ControlaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControlaApplication.class, args);
    }

    /*@Bean
    public HostAddrKeyResolver hostAddrKeyResolver() {
        return new HostAddrKeyResolver();
    }*/
    /*@Bean
    public UriKeyResolver uriKeyResolver() {
        return new UriKeyResolver();
    }
    @Bean
    KeyResolver userKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("user"));
    }*/
    @Bean
    KeyResolver hostAddrKeyResolver() {
        System.out.println("##############ipKeyResolver########################");
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
    }
//    @Bean
//    KeyResolver userKeyResolver() {
//        System.out.println("##############ipKeyResolver########################");
//        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("user"));
//    }
}
