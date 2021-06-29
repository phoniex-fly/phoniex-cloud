package com.phoenix.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Configuration;

/**
 * 路由配置
 */
@Configuration
public class RouteConfig {

    /**
     * oauth认证路径路由至认证服务
     *
     * @param builder
     * @return
     */
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("phoniex-server-auth-route",
                r -> r.path("/oauth/**").uri("lb://phoenix-server-auth"));
        return routes.build();
    }
}
