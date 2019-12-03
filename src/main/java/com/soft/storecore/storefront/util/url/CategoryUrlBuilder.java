package com.soft.storecore.storefront.util.url;

import com.soft.storecore.facade.category.data.CategoryData;
import com.soft.storecore.storefront.config.StorefrontConstants.RequestMappings;
import org.springframework.stereotype.Component;

@Component
public class CategoryUrlBuilder implements UrlBuilder<CategoryData> {

    @Override
    public String buildUrl(CategoryData model) {
        return "/products" +  RequestMappings.PRODUCTS_BY_CATEGORY + "/" + model.getCode();
    }
}
