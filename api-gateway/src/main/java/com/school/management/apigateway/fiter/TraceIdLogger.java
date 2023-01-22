package com.school.management.apigateway.fiter;

import brave.Tracer;
import io.micrometer.observation.Observation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Order(0)
@Configuration
public class TraceIdLogger implements GlobalFilter {

    private static final String TRACE_ID = "traceId";

    private static final Logger logger = LoggerFactory.getLogger(TraceIdLogger.class);

    @Autowired
    Tracer tracer;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            Observation gatewayObservation = exchange
                    .getRequiredAttribute(ServerWebExchangeUtils.GATEWAY_OBSERVATION_ATTR);
            gatewayObservation.scoped(() -> showLogs(exchange));
        }));
    }

    private void showLogs(ServerWebExchange exchange) {
        exchange.getResponse().getHeaders().add(TRACE_ID, tracer.currentSpan().context().traceIdString());
        logger.info("Request " + exchange.getRequest().getURI());
        logger.info("Response code " + exchange.getResponse().getStatusCode());
    }
}
