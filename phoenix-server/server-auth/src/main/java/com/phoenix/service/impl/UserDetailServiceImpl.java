package com.phoenix.service.impl;

import com.phoenix.common.AuthConstant;
import com.phoenix.feign.AuthUserFeign;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private AuthUserFeign authUserFeign;


    /**
     * header中存储登录类型，根据登录类型确定认证逻辑
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //获取请求头中的登录类型
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String loginType = attributes.getRequest().getHeader(AuthConstant.LOGIN_TYPE);
        if (StringUtils.isEmpty(loginType)) {
            return null;
        }
        return authUserFeign.loadUserByUsername(username, loginType);
    }
}
