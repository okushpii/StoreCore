package com.soft.storecore.facade.impl;

import com.soft.storecore.model.entity.Category;
import com.soft.storecore.model.service.CategoryService;
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
public class DefaultCategoryFacadeTest {

    @InjectMocks
    private DefaultCategoryFacade testedEntry;

    @Mock
    private CategoryService categoryService;
    @Mock
    private Category category;

    @Test
    public void shouldFindAll(){
        List<Category> categories = Collections.singletonList(category);
        when(categoryService.findAll()).thenReturn(categories);
        List<Category> result = testedEntry.findAll();

        assertEquals(categories, result);
    }

}