package com.soft.storecore.controller;

import com.soft.storecore.facade.ProductFacade;
import com.soft.storecore.facade.data.ProductData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.Model;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductPageControllerTest {

    private static final String PRODUCT_LIST_ATTRIBUTE = "productList";
    private static final String PRODUCT_LIST_PAGE = "pages/productListPage";

    @InjectMocks
    private ProductListPageController testedEntry;

    @Mock
    private ProductFacade productFacade;

    @Mock
    private Model model;

    @Test
    public void shouldGetProductPage() {
        List<ProductData> productList = Collections.singletonList(new ProductData());
        when(productFacade.findAllByCategoryId(anyLong())).thenReturn(productList);
        String result = testedEntry.getProductsPage(anyLong(), model);

        verify(model).addAttribute(PRODUCT_LIST_ATTRIBUTE, productList);
        assertEquals(PRODUCT_LIST_PAGE, result);

    }

}