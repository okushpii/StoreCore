package com.soft.storecore.core.service.impl;

import com.soft.storecore.core.category.dao.CategoryDao;
import com.soft.storecore.core.category.entity.Category;
import com.soft.storecore.core.category.service.DefaultCategoryService;
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
public class DefaultCategoryServiceTest {

    @InjectMocks
    private DefaultCategoryService testedEntry;

    @Mock
    private CategoryDao categoryDao;
    @Mock
    private Category category;

    @Test
    public void shouldFindAll(){
        List<Category> categories = Collections.singletonList(category);
        when(categoryDao.findAll()).thenReturn(categories);
        List<Category> result = testedEntry.findAll();

        assertEquals(categories, result);
    }

}