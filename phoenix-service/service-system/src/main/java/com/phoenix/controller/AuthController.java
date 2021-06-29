package com.phoenix.controller;

import com.phoenix.service.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthController {

    @Autowired
    private Map<String, AuthUserService> authUserService;

    @PostMapping("loadUserByUsername")
    public UserDetails loadUserByUsername(@RequestParam("username") String username, @RequestParam("loginType") String loginType) {
        AuthUserService authUserService = this.authUserService.get(loginType);
        if (authUserService == null) {
            return null;
        }
        return authUserService.loadUserByUsername(username);
    }

}
