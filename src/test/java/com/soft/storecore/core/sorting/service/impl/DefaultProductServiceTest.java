package com.soft.storecore.core.sorting.service.impl;

import com.soft.storecore.core.product.dao.ProductDao;
import com.soft.storecore.core.product.entity.Product;
import com.soft.storecore.core.product.service.DefaultProductService;
import com.soft.storecore.core.product.service.PaginationService;
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
    private static final int START = 6;
    private static final int PAGE_NUMBER = 2;
    private static final int PAGE_SIZE = 5;

    @InjectMocks
    private DefaultProductService testedEntry;

    @Mock
    private ProductDao productDao;
    @Mock
    private Product product;
    @Mock
    private PaginationService paginationService;

    @Test
    public void shouldFindProducts(){

        when(productDao.findAllByCategory(CATEGORY_CODE, null, START, PAGE_SIZE))
                .thenReturn(Collections.singletonList(product));
        when(paginationService.getStart(PAGE_NUMBER, PAGE_SIZE)).thenReturn(START);

        List<Product> result = testedEntry.findAllByCategory(CATEGORY_CODE, null,
                PAGE_NUMBER, PAGE_SIZE);

        assertEquals(Collections.singletonList(product), result);
    }

}
