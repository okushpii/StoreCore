package com.soft.storecore.facade.impl;

import com.soft.storecore.core.product.entity.Product;
import com.soft.storecore.core.pojo.Sorting;
import com.soft.storecore.core.product.service.ProductService;
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
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultProductFacadeTest {

    @InjectMocks
    private DefaultProductFacade testedEntry;

    @Mock
    private ProductService productService;
    @Mock
    private Product product;
    @Mock
    private ProductConverter productConverter;
    @Mock
    private Sorting sorting;

    @Test
    public void shouldFindAllByCategoryId(){
        List<Product> productList = Collections.singletonList(product);
        ProductData productData = new ProductData();

        when(productService.findAllByCategoryId(anyLong(), sorting)).thenReturn(productList);
        when(productConverter.convert(product)).thenReturn(productData);
        List<ProductData> result = testedEntry.findAllByCategoryId(anyLong(), anyString(), anyString());

        assertArrayEquals(Collections.singletonList(productData).toArray(), result.toArray());

    }
}
