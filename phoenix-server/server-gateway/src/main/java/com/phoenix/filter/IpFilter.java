package com.phoenix.filter;

import com.phoenix.config.IPWriteList;
import com.phoenix.util.GatewayError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * ip校验
 */
@Configuration
public class IpFilter implements GlobalFilter, Ordered {

    @Autowired
    private IPWriteList ipWriteList;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //白名单IP放行
        String hostName = exchange.getRequest().getHeaders().getHost().getHostName();
        if (ipWriteList.getWriteList().contains(hostName)) {
            return chain.filter(exchange);
        }
        //请求拦截 返回错误信息
        return GatewayError.forbidonIP(exchange);
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
