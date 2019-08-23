package com.soft.storecore.model.service.impl;

import com.soft.storecore.model.dao.ProductDao;
import com.soft.storecore.model.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class DefaultProductServiceTest {

    @InjectMocks
    private DefaultProductService testedEntry;

    @Mock
    private ProductDao productDao;
    @Mock
    private Product product;

    @Test
    public void shouldFindAllByCategoryId(){
        List<Product> productList = Collections.singletonList(product);
        when(productDao.findAllByCategoryId(anyLong())).thenReturn(productList);
        List<Product> result = testedEntry.findAllByCategoryId(anyLong());

        assertEquals(productList, result);
    }


}
