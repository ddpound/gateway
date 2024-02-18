package com.lubid.lubidgateway.filter;

import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Log4j2
public class RequestCheckFilter extends AbstractGatewayFilterFactory<RequestCheckFilter.Config> {
    public  RequestCheckFilter(){
        super(Config.class);
    }
    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain)->{
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            log.info("filter : request id -> {}" , request.getId());
            log.info("filter : request address -> {}" , request.getRemoteAddress());
            log.info("filter : request uri -> {}" , request.getURI());

            return chain.filter(exchange).then(Mono.fromRunnable(()->{
                log.info("filter : response code -> {}" , response.getStatusCode());
            }));
        };
    }

    public static class Config{

    }
}
