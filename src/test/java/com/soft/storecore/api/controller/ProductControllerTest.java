package com.soft.storecore.api.controller;

import com.soft.storecore.facade.product.data.ProductData;
import com.soft.storecore.facade.product.facade.ProductFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

    private static final String CATEGORY_CODE = "10";
    private static final String SORTING = "price";
    private static final int PAGE_NUMBER = 2;
    private static final int PAGE_SIZE = 5;

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductFacade productFacade;

    @Test
    public void shouldFindByCategory(){
        List<ProductData> expected = new ArrayList<>();
        when(productFacade.findAllByCategory(CATEGORY_CODE, SORTING, PAGE_NUMBER, PAGE_SIZE)).thenReturn(expected);

        List<ProductData> result = productController.findByCategory(CATEGORY_CODE, SORTING, PAGE_NUMBER, PAGE_SIZE);

        assertEquals(expected, result);
    }

}