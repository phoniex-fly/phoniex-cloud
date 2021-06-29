package com.phoenix.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * 封装向页面返回的错误信息
 */
public class GatewayError {

    /**
     * 非白名单IP
     *
     * @param exchange
     * @return
     */
    public static Mono<Void> forbidonIP(ServerWebExchange exchange) {
        Map<String, String> map = new HashMap<>(4);
        map.put("code", "401");
        map.put("msg", "非白名单IP");
        return response(exchange, HttpStatus.UNAUTHORIZED, map);
    }

    /**
     * 未授权
     *
     * @param exchange
     * @return
     */
    public static Mono<Void> unauthorized(ServerWebExchange exchange) {
        Map<String, String> map = new HashMap<>(4);
        map.put("code", "401");
        map.put("msg", "未授权");
        return response(exchange, HttpStatus.UNAUTHORIZED, map);
    }


    /**
     * 返回错误信息
     *
     * @param exchange
     * @return
     */
    private static Mono<Void> response(ServerWebExchange exchange, HttpStatus status, Map<String, String> map) {

        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(status);
        response.getHeaders().add("content-type", "application/json;charset=utf-8");

        ObjectMapper mapper = new ObjectMapper();
        byte[] bytes = new byte[0];
        try {
            bytes = mapper.writeValueAsBytes(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        DataBuffer wrap = response.bufferFactory().wrap(bytes);
        return response.writeWith(Mono.just(wrap));
    }
}
