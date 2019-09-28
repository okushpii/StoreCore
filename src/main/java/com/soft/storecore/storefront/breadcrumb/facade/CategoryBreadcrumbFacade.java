package com.soft.storecore.storefront.breadcrumb.facade;

import com.soft.storecore.facade.category.data.CategoryData;
import com.soft.storecore.facade.category.facade.CategoryFacade;
import com.soft.storecore.storefront.breadcrumb.builder.BreadcrumbBuilder;
import com.soft.storecore.storefront.breadcrumb.pojo.Breadcrumb;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class CategoryBreadcrumbFacade implements BreadcrumbFacade {

    @Resource
    private CategoryFacade categoryFacade;
    @Resource
    private BreadcrumbBuilder<CategoryData> categoryBreadcrumbBuilder;

    @Override
    public List<Breadcrumb> getBreadcrumbs(Long categoryId) {
        List<CategoryData> categories = categoryFacade.findSupercategories(categoryId);
        return categoryBreadcrumbBuilder.buildBreadcrumbs(categories);
    }
}
