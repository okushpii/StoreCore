package com.soft.storecore.facade.core.populator;

import com.soft.storecore.core.entity.Category;
import com.soft.storecore.core.entity.Product;
import com.soft.storecore.facade.product.data.ProductData;
import com.soft.storecore.facade.product.populator.ProductPopulator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductPopulatorTest {

    private static final long PRODUCT_ID = 10L;
    private static final String PRODUCT_NAME = "productName";
    private static final long PRODUCT_PRICE = 200L;
    private static final String PRODUCT_IMAGE_URL = "productImageUrl";
    private static final String PRODUCT_DESCRIPTION = "productDescription";

    @InjectMocks
    private ProductPopulator testedInstance;

    @Mock
    private Category category;
    @Mock
    private Product product;

    @Test
    public void shouldPopulateProductsData() {
        ProductData productData = new ProductData();

        prepareProduct();
        testedInstance.populate(product, productData);

        assertEquals(String.valueOf(PRODUCT_ID), productData.getId().toString());
        assertEquals(PRODUCT_NAME, productData.getName());
        assertEquals(String.valueOf(PRODUCT_PRICE), productData.getPrice().toString());
        assertEquals(PRODUCT_IMAGE_URL, productData.getImageUrl());
        assertEquals(PRODUCT_DESCRIPTION, productData.getDescription());
        assertEquals(category, productData.getCategory());
    }

    private void prepareProduct() {
        when(product.getId()).thenReturn(PRODUCT_ID);
        when(product.getName()).thenReturn(PRODUCT_NAME);
        when(product.getPrice()).thenReturn(PRODUCT_PRICE);
        when(product.getImageUrl()).thenReturn(PRODUCT_IMAGE_URL);
        when(product.getDescription()).thenReturn(PRODUCT_DESCRIPTION);
        when(product.getCategory()).thenReturn(category);

    }
}
