package com.phoenix.filter;

import com.phoenix.common.GatewayConstant;
import com.phoenix.common.RedisConstant;
import com.phoenix.config.PathPassList;
import com.phoenix.util.GatewayError;
import com.phoenix.util.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * token校验
 */
@Configuration
public class TokenFilter implements GlobalFilter, Ordered {

    @Autowired
    private RedisCache redisCache;
    @Autowired
    private PathPassList pathPassList;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //放行的路径直接放行
        String path = exchange.getRequest().getURI().getPath();
        if (pathPassList.getPass().contains(path)) {
            return chain.filter(exchange);
        }
        //非放行的路径，获取请求头中的token
        List<String> tokens = exchange.getRequest().getHeaders().get(GatewayConstant.HEADER_AUTHORIZATION);
        if (tokens != null && tokens.size() > 0) {
            String token = tokens.get(0);
            if (StringUtils.hasText(token)) {
                token = token.replace(GatewayConstant.TOKEN_PREFIX, GatewayConstant.NO_CONTENT);
                //查看redis中是否存在token
                String redis_token = RedisConstant.REDIS_TOKEN_PREFIX + token;
                Boolean hasKey = redisCache.hasKey(redis_token);
                //redis中有key,直接放行
                if (hasKey) {
                    return chain.filter(exchange);
                }
            }
        }
        //请求被拦截，返回错误信息
        return GatewayError.unauthorized(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
