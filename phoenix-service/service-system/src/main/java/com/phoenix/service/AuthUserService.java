package com.phoenix.service;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface AuthUserService {

    default UserDetails loadUserByUsername(String username) {
        UserDetails user = findUserByUsername(username);
        if (user != null) {
            findAuths(user);
        }
        return user;
    }


    UserDetails findUserByUsername(String username);

    List<String> findAuths(UserDetails user);
}
