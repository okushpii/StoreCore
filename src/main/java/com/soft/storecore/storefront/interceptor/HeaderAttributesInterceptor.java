package com.soft.storecore.storefront.interceptor;

import com.soft.storecore.facade.category.data.CategoryData;
import com.soft.storecore.facade.category.facade.CategoryFacade;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

import static com.soft.storecore.storefront.config.StorefrontConstants.Attributes.CATEGORIES;

@Component
public class HeaderAttributesInterceptor extends HandlerInterceptorAdapter {

    @Resource
    private CategoryFacade categoryFacade;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) {

       if (isRequestMethodGet(request) && Objects.nonNull(modelAndView)){
           addCategoriesAttribute(modelAndView);
       }
    }

    private boolean isRequestMethodGet(HttpServletRequest request) {
        return request.getMethod().equals(RequestMethod.GET.name());
    }

    private void addCategoriesAttribute(ModelAndView modelAndView) {
        List<CategoryData> categories = categoryFacade.findAll();
        if (!categories.isEmpty()) {
            modelAndView.addObject(CATEGORIES, categories);
        }
    }
}
