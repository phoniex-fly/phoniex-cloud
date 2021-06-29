package com.phoenix.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "path")
public class PathPassList {

    private List<String> pass;

    public List<String> getPass() {
        return pass;
    }

    public void setPass(List<String> pass) {
        this.pass = pass;
    }
}
