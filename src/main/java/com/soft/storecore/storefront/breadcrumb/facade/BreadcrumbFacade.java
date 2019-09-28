package com.soft.storecore.storefront.breadcrumb.facade;

import com.soft.storecore.storefront.breadcrumb.pojo.Breadcrumb;

import java.util.List;

public interface BreadcrumbFacade {

    List<Breadcrumb> getBreadcrumbs(Long categoryId);
}
