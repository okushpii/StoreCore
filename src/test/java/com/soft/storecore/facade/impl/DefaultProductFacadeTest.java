package com.soft.storecore.facade.impl;

import com.soft.storecore.core.entity.Product;
import com.soft.storecore.core.service.ProductService;
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

    @Test
    public void shouldFindAllByCategoryId(){
        List<Product> productList = Collections.singletonList(product);
        ProductData productData = new ProductData();

        when(productService.findAllByCategoryId(anyLong())).thenReturn(productList);
        when(productConverter.convert(product)).thenReturn(productData);
        List<ProductData> result = testedEntry.findAllByCategoryId(anyLong());

        assertArrayEquals(Collections.singletonList(productData).toArray(), result.toArray());

    }
}
