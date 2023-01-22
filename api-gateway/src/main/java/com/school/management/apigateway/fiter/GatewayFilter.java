package com.school.management.apigateway.fiter;

import io.micrometer.observation.Observation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Configuration
@Order(-1)
public class GatewayFilter implements GlobalFilter {
    private static final Logger logger = LoggerFactory.getLogger(GatewayFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        final ServerHttpRequest serverHttpRequest = exchange.getRequest();
        logger.info("Authorization = " + serverHttpRequest.getHeaders().getFirst("Authorization"));
        logger.info("URL = " + serverHttpRequest.getURI().getPath());

        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            logger.info("GatewayFilter completed");
        }));
    }


}
