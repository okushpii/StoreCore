package com.soft.storecore.facade.impl;

import com.soft.storecore.facade.converter.impl.CategoryConverter;
import com.soft.storecore.facade.data.CategoryData;
import com.soft.storecore.model.entity.Category;
import com.soft.storecore.model.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultCategoryFacadeTest {

    @InjectMocks
    private DefaultCategoryFacade testedEntry;

    @Mock
    private CategoryService categoryService;
    @Mock
    private Category category;
    @Mock
    private CategoryConverter categoryConverter;


    @Test
    public void shouldFindAll(){
        List<Category> categories = Collections.singletonList(category);
        CategoryData categoryData = new CategoryData();

        when(categoryService.findAll()).thenReturn(categories);
        when(categoryConverter.convert(category)).thenReturn(categoryData);
        List<CategoryData> result = testedEntry.findAll();

        assertArrayEquals(Collections.singletonList(categoryData).toArray(), result.toArray());
    }

}