package com.soft.storecore.storefront.config;

public interface StorefrontConstants {

    interface RequestMappings {

        String HOME_PAGE ="/";
        String PRODUCTS_BY_CATEGORY = "/c";
    }

    interface Pages {

        String HOME_PAGE = "pages/homePage";
        String PRODUCT_LIST_PAGE = "pages/productListPage";
    }

    interface Attributes {

        String CATEGORIES = "categories";
        String PRODUCT_LIST = "productList";
        String CATEGORY_CODE = "categoryCode";
        String SORTING_FIELD = "sortingField";
        String SORTING_TYPE = "sortingType";
        String BREADCRUMBS = "breadcrumbs";
    }
}
