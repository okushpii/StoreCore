package com.soft.storecore.core.sorting.impl;

import com.soft.storecore.core.product.dao.ProductDao;
import com.soft.storecore.core.product.entity.Product;
import com.soft.storecore.core.product.service.DefaultProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultProductServiceTest {

    private static final String CATEGORY_CODE = "23";

    @InjectMocks
    private DefaultProductService testedEntry;

    @Mock
    private ProductDao productDao;
    @Mock
    private Product product;

    @Test
    public void shouldFindProducts(){
        when(productDao.findAllByCategory(CATEGORY_CODE, null))
                .thenReturn(Collections.singletonList(product));
        List<Product> result = testedEntry.findAllByCategory(CATEGORY_CODE, null);

        assertEquals(Collections.singletonList(product), result);
    }

}
