package com.soft.storecore.facade.converter.impl;

import com.soft.storecore.facade.data.ProductData;
import com.soft.storecore.facade.populator.ProductPopulator;
import com.soft.storecore.model.entity.Product;
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
