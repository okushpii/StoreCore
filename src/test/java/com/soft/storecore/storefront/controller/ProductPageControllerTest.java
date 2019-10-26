package com.soft.storecore.storefront.controller;

import com.soft.storecore.facade.media.ImageFormatFacade;
import com.soft.storecore.facade.product.data.ProductData;
import com.soft.storecore.facade.product.facade.ProductFacade;
import com.soft.storecore.facade.sorting.data.SortingData;
import com.soft.storecore.facade.sorting.facade.SortingFacade;
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

    private static final String IMAGE_FORMAT_KEY = "media.product.list.image.format";
    private static final String SORTING_GROUP_KEY = "sorting.group.product";

    private static final String PRODUCT_LIST_ATTRIBUTE = "productList";
    private static final String BREDCRUMB_ATTRIBUTE = "breadcrumbs";
    private static final String SORTING_LIST_ATTRIBUTE = "sortingList";
    private static final String IMAGE_FORMAT_ATTRIBUTE = "imageFormat";

    private static final String CATEGORY_CODE = "10";
    private static final String SORTING = "price";
    private static final String IMAGE_FORMAT = "730x560";

    private static final String PRODUCT_LIST_PAGE = "pages/productListPage";

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
    @Mock
    private ImageFormatFacade imageFormatFacade;
    @Mock
    private SortingFacade sortingFacade;

    @Test
    public void shouldGetProductPage() {
        List<ProductData> productList = Collections.singletonList(new ProductData());
        List<Breadcrumb> breadcrumbList = Collections.singletonList(breadcrumb);
        List<SortingData> sortingList = List.of(new SortingData());

        when(productFacade.findAllByCategory(CATEGORY_CODE, SORTING)).thenReturn(productList);
        when(breadcrumbFacade.getBreadcrumbs(CATEGORY_CODE)).thenReturn(breadcrumbList);
        when(imageFormatFacade.getFormat(IMAGE_FORMAT_KEY)).thenReturn(IMAGE_FORMAT);
        when(sortingFacade.find(SORTING_GROUP_KEY, SORTING)).thenReturn(sortingList);
        String result = testedEntry.getByCategory(CATEGORY_CODE, SORTING, model);

        verify(model).addAttribute(PRODUCT_LIST_ATTRIBUTE, productList);
        verify(model).addAttribute(BREDCRUMB_ATTRIBUTE, breadcrumbList);
        verify(model).addAttribute(IMAGE_FORMAT_ATTRIBUTE, IMAGE_FORMAT);
        verify(model).addAttribute(SORTING_LIST_ATTRIBUTE, sortingList);
        assertEquals(PRODUCT_LIST_PAGE, result);
    }

}
