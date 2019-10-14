package com.soft.storecore.facade.util.populator;

import com.soft.storecore.core.category.entity.Category;
import com.soft.storecore.core.product.entity.Product;
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

    private static final String PRODUCT_CODE = "10";
    private static final String PRODUCT_NAME = "productName";
    private static final long PRODUCT_PRICE = 200L;
    private static final String PRODUCT_IMAGE_CODE = "product/p-img";
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

        assertEquals(PRODUCT_CODE, productData.getCode());
        assertEquals(PRODUCT_NAME, productData.getName());
        assertEquals(String.valueOf(PRODUCT_PRICE), productData.getPrice().toString());
        assertEquals(PRODUCT_IMAGE_CODE, productData.getImageCode());
        assertEquals(PRODUCT_DESCRIPTION, productData.getDescription());
        assertEquals(category, productData.getCategory());
    }

    private void prepareProduct() {
        when(product.getCode()).thenReturn(PRODUCT_CODE);
        when(product.getName()).thenReturn(PRODUCT_NAME);
        when(product.getPrice()).thenReturn(PRODUCT_PRICE);
        when(product.getImageCode()).thenReturn(PRODUCT_IMAGE_CODE);
        when(product.getDescription()).thenReturn(PRODUCT_DESCRIPTION);
        when(product.getCategory()).thenReturn(category);

    }
}
