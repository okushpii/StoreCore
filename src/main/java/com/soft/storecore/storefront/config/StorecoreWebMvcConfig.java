package com.soft.storecore.storefront.config;

import com.soft.storecore.storefront.interceptor.CategoriesInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

import static com.soft.storecore.storefront.config.ControllerConstants.RequestMappings.HOME_PAGE;
import static com.soft.storecore.storefront.config.ControllerConstants.RequestMappings.PRODUCT_LIST;

@Configuration
public class StorecoreWebMvcConfig implements WebMvcConfigurer {

    private static final String ALL_MATCH_PATTERN = "/**";

    @Resource
    private CategoriesInterceptor categoriesInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(categoriesInterceptor).addPathPatterns(
                HOME_PAGE + ALL_MATCH_PATTERN,
                PRODUCT_LIST + ALL_MATCH_PATTERN
        );
    }
}
