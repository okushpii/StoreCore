package com.soft.storecore.storefront.breadcrumb.builder;

import com.google.common.collect.Iterables;
import com.soft.storecore.facade.category.data.CategoryData;
import com.soft.storecore.storefront.breadcrumb.pojo.Breadcrumb;
import com.soft.storecore.storefront.util.url.UrlBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryBreadcrumbBuilder implements BreadcrumbBuilder<CategoryData> {

    @Resource
    private UrlBuilder<CategoryData> categoryUrlBuilder;

    @Override
    public List<Breadcrumb> buildBreadcrumbs(List<CategoryData> values) {
        Collections.reverse(values);
        List<Breadcrumb> breadcrumbs = values.stream()
                .map(this::createBreadcrumb).collect(Collectors.toList());
        markLastBreadcrumb(breadcrumbs);
        return breadcrumbs;
    }

    private Breadcrumb createBreadcrumb(CategoryData categoryData) {
        return new Breadcrumb(categoryData.getName(), categoryUrlBuilder.buildUrl(categoryData));
    }

    private void markLastBreadcrumb(List<Breadcrumb> breadcrumbs){
        Iterables.getLast(breadcrumbs).setLast(true);
    }
}
