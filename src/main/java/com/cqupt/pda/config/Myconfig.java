package com.cqupt.pda.config;

import com.cqupt.pda.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: Jack Lu
 * @Date: 2022/5/26 9:36
 */
@Configuration
public class Myconfig {
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginInterceptor())
                        .addPathPatterns("/**")//所有请求都会被拦截包包括静态资源
                        .excludePathPatterns("/","/user","/register.html","/css/**","/login",
                                "/fonts/**","/images/**","/js/**","/reg","/find","/find.html","/img/**");

            }
        };
    }
}
