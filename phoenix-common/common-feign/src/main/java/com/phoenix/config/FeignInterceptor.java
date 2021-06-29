package com.phoenix.config;

import com.phoenix.common.FeignConstant;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * feign请求拦截处理
 */
public class FeignInterceptor implements RequestInterceptor {

    /**
     * 做token传递
     * 1、浏览器-->A服务-->B服务 有request有toekn
     * 2、mq监听中远程调用 无request无toekn
     * 3、第三方回调，没有token 有request无toekn
     *
     * @param requestTemplate 发起远程调用的请求
     */
    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //可能mq监听中远程调用
        if (attributes == null) {
            //设置永久token,即客户端模式颁发的token
            requestTemplate.header(FeignConstant.HEADER_AUTHORIZATION, "Bearer ");
            return;
        }
        //从浏览器带过来的请求
        String token = attributes.getRequest().getHeader(FeignConstant.HEADER_AUTHORIZATION);
        if (!StringUtils.isEmpty(token)) {
            //浏览器请求，往新的请求里放传递的token
            requestTemplate.header(FeignConstant.HEADER_AUTHORIZATION, token);
        } else {
            //第三方回调，设置永久token,即客户端模式颁发的token
            requestTemplate.header(FeignConstant.HEADER_AUTHORIZATION, "Bearer ");
        }
    }

}
