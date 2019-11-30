package com.soft.storecore.api.controller;

import com.soft.storecore.facade.category.data.CategoryData;
import com.soft.storecore.facade.category.facade.CategoryFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CategoryControllerTest {

    @InjectMocks
    private CategoryController testedInstance;

    @Mock
    private CategoryFacade categoryFacade;

    @Test
    public void shouldReturnCategories(){
        List<CategoryData> categories = List.of(new CategoryData());

        when(categoryFacade.findAll()).thenReturn(categories);
        List<CategoryData> result = testedInstance.getCategories();

        assertEquals(categories, result);
    }

}