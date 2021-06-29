package com.phoenix.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "ip")
public class IPWriteList {

    private List<String> writeList;

    public List<String> getWriteList() {
        return writeList;
    }

    public void setWriteList(List<String> writeList) {
        this.writeList = writeList;
    }
}
