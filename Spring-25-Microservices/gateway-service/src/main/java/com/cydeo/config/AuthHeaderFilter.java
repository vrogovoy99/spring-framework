package com.cydeo.config;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthHeaderFilter implements GatewayFilter {
//    extract token from the request and append it to response
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        ServerWebExchange contains incoming request and outgoing response
//        GatewayFilterChain contains a list of filters for Gateway to apply
        ServerHttpRequest request = exchange.getRequest();
//        Make sure import org.springframework.http.server.reactive.ServerHttpRequest;
//        and not   import org.springframework.http.server.ServerHttpRequest;

        if (request.getHeaders().containsKey("Authorization")){

            String authorizationHeaderValue = request.getHeaders().getFirst("Authorization");
            ServerHttpRequest modifiedRequest = request.mutate()
                    .header("Authorization", authorizationHeaderValue)
                    .build();

            return chain.filter(exchange.mutate().request(modifiedRequest).build());
        }

        return chain.filter(exchange);
    }
}
