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
        String SORTING_LIST = "sortingList";
        String BREADCRUMBS = "breadcrumbs";
        String IMAGE_FORMAT = "imageFormat";
    }

    interface Configuration {

        String IMAGE_FORMAT_KEY = "media.product.list.image.format";
        String SORTING_GROUP_KEY = "sorting.group.product";
    }
}
