package com.soft.storecore.storefront.util.url;

import com.soft.storecore.facade.category.data.CategoryData;
import com.soft.storecore.storefront.config.StorefrontConstants;
import org.springframework.stereotype.Component;

@Component
public class CategoryUrlBuilder<T> implements UrlBuilder<CategoryData> {

    @Override
    public String buildUrl(CategoryData model) {
        return StorefrontConstants.RequestMappings.PRODUCT_LIST + "/" + model.getId();
    }
}
