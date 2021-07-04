package com.phoenix.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //关闭跨站请求攻击
        http.csrf().disable();
        //放行监控路径
        http.authorizeRequests().antMatchers("/actuator/**").permitAll();
//        //登录
//        http.formLogin();
//        //其他请求均需认证
//        http.authorizeRequests().anyRequest().authenticated();
//        //
//        http.httpBasic();

        super.configure(http);

    }
}
