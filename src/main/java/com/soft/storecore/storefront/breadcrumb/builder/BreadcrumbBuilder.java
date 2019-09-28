package com.soft.storecore.storefront.breadcrumb.builder;

import com.soft.storecore.storefront.breadcrumb.pojo.Breadcrumb;

import java.util.List;

public interface BreadcrumbBuilder<T> {

    List<Breadcrumb> buildBreadcrumbs(List<T> values);
}
