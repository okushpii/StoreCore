package com.soft.storecore.model.service.impl;

import com.soft.storecore.model.dao.CategoryDao;
import com.soft.storecore.model.entity.Category;
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