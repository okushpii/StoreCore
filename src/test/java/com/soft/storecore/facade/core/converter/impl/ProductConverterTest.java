package com.soft.storecore.facade.core.converter.impl;

import com.soft.storecore.core.entity.Product;
import com.soft.storecore.facade.product.converter.ProductConverter;
import com.soft.storecore.facade.product.data.ProductData;
import com.soft.storecore.facade.product.populator.ProductPopulator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProductConverterTest {

    @InjectMocks
    private ProductConverter testedInstance;
    @Mock
    private Product product;
    @Mock
    private ProductPopulator productPopulator;

    @Test
    public void shouldConvertProduct(){
        ProductData result = testedInstance.convert(product);
        verify(productPopulator).populate(product, result);
    }
}
