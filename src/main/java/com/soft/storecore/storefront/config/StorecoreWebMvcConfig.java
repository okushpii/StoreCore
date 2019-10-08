package com.soft.storecore.storefront.config;

import com.soft.storecore.storefront.interceptor.HeaderAttributesInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

import static com.soft.storecore.storefront.config.StorefrontConstants.RequestMappings.HOME_PAGE;
import static com.soft.storecore.storefront.config.StorefrontConstants.RequestMappings.PRODUCTS_BY_CATEGORY;

@Configuration
public class StorecoreWebMvcConfig implements WebMvcConfigurer {

    private static final String ALL_MATCH_PATTERN = "/**";

    @Resource
    private HeaderAttributesInterceptor headerAttributesInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(headerAttributesInterceptor).addPathPatterns(
                HOME_PAGE + ALL_MATCH_PATTERN,
                PRODUCTS_BY_CATEGORY + ALL_MATCH_PATTERN
        );
    }
}
