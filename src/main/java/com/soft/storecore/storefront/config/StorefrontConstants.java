package com.soft.storecore.storefront.config;

public interface StorefrontConstants {

    interface RequestMappings {

        String HOME_PAGE ="/";
        String PRODUCT_LIST = "/productList";
    }

    interface Pages {

        String HOME_PAGE = "pages/homePage";
        String PRODUCT_LIST_PAGE = "pages/productListPage";
    }

    interface Attributes {

        String CATEGORIES = "categories";
        String PRODUCT_LIST = "productList";
        String CATEGORY_ID = "categoryId";
        String SORTING_FIELD = "sortingField";
        String SORTING_TYPE = "sortingType";
        String BREADCRUMBS = "breadcrumbs";
    }
}
