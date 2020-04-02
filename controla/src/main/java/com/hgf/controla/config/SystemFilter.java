package com.hgf.controla.config;

import cn.hutool.db.nosql.redis.RedisDS;
import com.hgf.controla.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import redis.clients.jedis.Jedis;

import java.util.concurrent.TimeUnit;

/**
 * created by hgf
 * created time is 2020/3/1
 */
// @Configuration
public class SystemFilter implements GlobalFilter, Ordered {
    private Jedis jedis = RedisDS.create().getJedis();

    private final String TOKRN = "token";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        String path = request.getURI().getPath();
        System.out.println("拦截请求地址" + path);
        //如果是登录请求不校验不拦截
        if (path.equals("/login")) {
            return chain.filter(exchange);
        } else {
            try {
                // todo 这种方法感觉不太好，但是暂时没想到好方案，后续在修改
                // 为了让一直在使用的人token不会失效。
                String token = request.getCookies().get(TOKRN).get(0).getValue();
                Long t = jedis.ttl("hgf");
                String rt = jedis.get("hgf");
                if (token.equals(rt)) {
                    // 当redis过期时间小于指定时间时，重新设置过期时间
                    if (t < 10) {
                        jedis.expire("hgf", 60);
                    }
                    return chain.filter(exchange);
                }
                response.setStatusCode(HttpStatus.UNAUTHORIZED);
                return response.setComplete();
            } catch (Exception e) {
                e.printStackTrace();
                response.setStatusCode(HttpStatus.UNAUTHORIZED);
                return response.setComplete();
            }

            /*try {
                JwtUtils.parseJWT(token);
                return chain.filter(exchange);
            } catch (Exception e) {
                e.printStackTrace();
                response.setStatusCode(HttpStatus.UNAUTHORIZED);
                return response.setComplete();
            }*/
        }

    }

    @Override
    public int getOrder() {
        return 2;
    }
}
