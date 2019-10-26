package com.soft.storecore.facade.impl;

import com.soft.storecore.core.product.entity.Product;
import com.soft.storecore.core.product.service.ProductService;
import com.soft.storecore.core.sorting.entity.Sorting;
import com.soft.storecore.core.sorting.service.SortingService;
import com.soft.storecore.facade.product.converter.ProductConverter;
import com.soft.storecore.facade.product.data.ProductData;
import com.soft.storecore.facade.product.facade.DefaultProductFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultProductFacadeTest {

    private static final String CATEGORY_CODE = "12";
    private static final String SORTING_CODE = "product";


    @InjectMocks
    private DefaultProductFacade testedEntry;

    @Mock
    private ProductService productService;
    @Mock
    private Product product;
    @Mock
    private ProductConverter productConverter;
    @Mock
    private SortingService sortingService;
    @Mock
    private Sorting sorting;

    @Test
    public void shouldFindAllByCategoryId() {
        List<Product> products = List.of(this.product);
        List<ProductData> productDataList = List.of(new ProductData());

        when(sortingService.find(SORTING_CODE)).thenReturn(Optional.of(sorting));
        when(productService.findAllByCategory(CATEGORY_CODE, sorting)).thenReturn(products);
        when(productConverter.convertAll(products)).thenReturn(productDataList);
        List<ProductData> result = testedEntry.findAllByCategory(CATEGORY_CODE, SORTING_CODE);

        assertEquals(productDataList, result);
    }
}
