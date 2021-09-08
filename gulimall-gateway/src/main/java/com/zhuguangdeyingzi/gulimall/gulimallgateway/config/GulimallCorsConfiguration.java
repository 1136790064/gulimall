package com.zhuguangdeyingzi.gulimall.gulimallgateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * @author: lijun
 * @description: 允许跨域的配置类
 * @date: 2021/8/30 16:58
 */

@Configuration
public class GulimallCorsConfiguration {
    @Bean
    public CorsWebFilter corsWebFilter(){

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //1、配置跨域
        //允许所有请求头进行跨域
        corsConfiguration.addAllowedHeader("*");
        //允许所有请求方法进行跨域
        corsConfiguration.addAllowedMethod("*");
        //允许所有请求来源进行跨域
        corsConfiguration.addAllowedOriginPattern("*");
        //允许所有请求携带cookie进行跨域
        corsConfiguration.setAllowCredentials(true);
        
        
        source.registerCorsConfiguration("/**",corsConfiguration);
        return new CorsWebFilter(source);
    }

    
}
