package com.school.management.apigateway.fiter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Configuration
public class GatewayFilter implements GlobalFilter {
    final Logger logger = LoggerFactory.getLogger(GatewayFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        final ServerHttpRequest serverHttpRequest = exchange.getRequest();
        logger.info("Authorization = " + serverHttpRequest.getHeaders().getFirst("Authorization"));

        // Pre-filter
        //return chain.filter(exchange);

        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            // Post filter
            logger.info("Response code "+exchange.getResponse().getRawStatusCode());
        }));
    }
}
