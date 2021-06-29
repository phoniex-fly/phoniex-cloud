package com.phoenix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("config")
public class ConfigServerController {

    @Autowired
    private RestTemplate restTemplate;
    @Value(value = "${server.port}")
    private String port;

    /**
     * 远端git仓库配置webhook调用此接口通知配置刷新
     *
     * @return
     */
    @PostMapping("refresh")
    public ResponseEntity<String> refresh() {
        String URL = "http://localhost:" + port + "/actuator/bus-refresh";
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-type", "application/json;charset=utf-8");
        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<String> response = restTemplate.postForEntity(URL, request, String.class);
        if (response.getStatusCode().equals(HttpStatus.NO_CONTENT)) {
            //成功
            return ResponseEntity.ok("配置文件刷新成功");
        }
        return ResponseEntity.badRequest().body("配置文件刷新失败");

    }


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
