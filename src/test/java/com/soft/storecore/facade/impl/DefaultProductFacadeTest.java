package com.soft.storecore.facade.impl;

import com.soft.storecore.core.product.entity.Product;
import com.soft.storecore.core.product.service.ProductService;
import com.soft.storecore.core.sorting.SortingService;
import com.soft.storecore.core.sorting.pojo.SortingData;
import com.soft.storecore.facade.product.converter.ProductConverter;
import com.soft.storecore.facade.product.data.ProductData;
import com.soft.storecore.facade.product.facade.DefaultProductFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultProductFacadeTest {

    private static final long CATEGORY_ID = 12L;

    @InjectMocks
    private DefaultProductFacade testedEntry;

    @Mock
    private ProductService productService;
    @Mock
    private Product product;
    @Mock
    private ProductConverter productConverter;
    @Mock
    private SortingData sortingData;
    @Mock
    private SortingService sortingService;

    @Test
    public void shouldFindAllByCategoryId(){
        List<Product> productList = Collections.singletonList(product);
        ProductData productData = new ProductData();

        when(productService.findAllByCategoryId(CATEGORY_ID, sortingData)).thenReturn(productList);
        when(productConverter.convert(product)).thenReturn(productData);
        when(sortingService.getSorting(anyString(), anyString())).thenReturn(sortingData);
        List<ProductData> result = testedEntry.findAllByCategoryId(CATEGORY_ID, "price"
                , "asc");

        assertArrayEquals(Collections.singletonList(productData).toArray(), result.toArray());

    }
}
