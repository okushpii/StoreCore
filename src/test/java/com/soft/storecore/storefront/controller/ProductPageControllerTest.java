package com.soft.storecore.storefront.controller;

import com.soft.storecore.facade.product.data.ProductData;
import com.soft.storecore.facade.product.facade.ProductFacade;
import com.soft.storecore.storefront.breadcrumb.facade.BreadcrumbFacade;
import com.soft.storecore.storefront.breadcrumb.pojo.Breadcrumb;
import com.soft.storecore.storefront.controller.page.ProductListPageController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.Model;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductPageControllerTest {

    private static final String PRODUCT_LIST_ATTRIBUTE = "productList";
    private static final String BREDCRUMB_ATTRIBUTE = "breadcrumbs";
    private static final String PRODUCT_LIST_PAGE = "pages/productListPage";

    private static final String CATEGORY_CODE = "10";
    private static final String SORTING_FIELD = "price";
    private static final String SORING_TYPE = "asc";

    @InjectMocks
    private ProductListPageController testedEntry;

    @Mock
    private ProductFacade productFacade;

    @Mock
    private Model model;

    @Mock
    private BreadcrumbFacade breadcrumbFacade;

    @Mock
    private Breadcrumb breadcrumb;

    @Test
    public void shouldGetProductPage() {
        List<ProductData> productList = Collections.singletonList(new ProductData());
        List<Breadcrumb> breadcrumbList = Collections.singletonList(breadcrumb);
        when(productFacade.findAllByCategory(CATEGORY_CODE, SORTING_FIELD, SORING_TYPE)).thenReturn(productList);
        when(breadcrumbFacade.getBreadcrumbs(CATEGORY_CODE)).thenReturn(breadcrumbList);
        String result = testedEntry.getByCategory(CATEGORY_CODE, model, SORTING_FIELD, SORING_TYPE);

        verify(model).addAttribute(PRODUCT_LIST_ATTRIBUTE, productList);
        verify(model).addAttribute(BREDCRUMB_ATTRIBUTE, breadcrumbList);
        assertEquals(PRODUCT_LIST_PAGE, result);

    }

}
