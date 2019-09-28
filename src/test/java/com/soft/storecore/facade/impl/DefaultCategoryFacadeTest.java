package com.soft.storecore.facade.impl;

import com.soft.storecore.core.category.entity.Category;
import com.soft.storecore.core.category.service.CategoryService;
import com.soft.storecore.facade.category.converter.CategoryConverter;
import com.soft.storecore.facade.category.data.CategoryData;
import com.soft.storecore.facade.category.facade.DefaultCategoryFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultCategoryFacadeTest {

    private static final long CATEGORY_ID = 12L;

    @InjectMocks
    private DefaultCategoryFacade testedEntry;

    @Mock
    private CategoryService categoryService;
    @Mock
    private Category category;
    @Mock
    private CategoryConverter categoryConverter;


    @Test
    public void shouldFindAll() {
        List<Category> categories = Collections.singletonList(category);
        List<CategoryData> categoryDataList = Collections.singletonList(new CategoryData());

        when(categoryService.findAll()).thenReturn(categories);
        when(categoryConverter.convertAll(categories)).thenReturn(categoryDataList);
        List<CategoryData> result = testedEntry.findAll();

        assertArrayEquals(categoryDataList.toArray(), result.toArray());
    }

    @Test
    public void shouldFindSuperCategoriesWhenAbsent() {
       when(categoryService.findById(CATEGORY_ID)).thenReturn(null);

       List<Category> result = categoryService.findSupercategories(category);

       assertEquals(Collections.emptyList(), result);

    }

    @Test
    public void shouldFindSuperCategoriesWhenPresent(){
        List<Category> categories = new ArrayList<>();

        when(categoryService.findSupercategories(category)).thenReturn(categories);
        List<CategoryData> result = testedEntry.findSupercategories(CATEGORY_ID);

        assertEquals(categories, result);





    }
}
