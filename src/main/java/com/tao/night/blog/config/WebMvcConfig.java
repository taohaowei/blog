package com.tao.night.blog.config;

import com.tao.night.blog.interceptor.LoadInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private LoadInterceptor loadInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loadInterceptor)
                .addPathPatterns("/**") // 拦截所有路径
                .excludePathPatterns("/static/**", "/error");
//                .addPathPatterns("/*.action", "/*/*.action", "/*.html", "/*/*.html")
        // 如需排除路径，可使用 .excludePathPatterns("/login.action")
        ;
    }
}
