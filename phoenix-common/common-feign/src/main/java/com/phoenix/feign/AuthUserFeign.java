package com.phoenix.feign;

import com.phoenix.common.ServiceNameConstant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(contextId = "authUserFeign", value = ServiceNameConstant.SERVICE_SYSTEM)
public interface AuthUserFeign {

    @PostMapping("loadUserByUsername")
    UserDetails loadUserByUsername(@RequestParam("username") String username, @RequestParam("loginType") String loginType);
}
