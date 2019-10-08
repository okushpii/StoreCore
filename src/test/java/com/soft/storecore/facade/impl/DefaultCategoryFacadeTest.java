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

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultCategoryFacadeTest {

    private static final String CATEGORY_CODE = "12";

    @InjectMocks
    private DefaultCategoryFacade testedEntry;

    @Mock
    private CategoryService categoryService;
    @Mock
    private Category category;
    @Mock
    private CategoryConverter categoryConverter;
    @Mock
    private CategoryData categoryData;


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
        List<Category> result = categoryService.findSupercategories(category);

        assertEquals(Collections.emptyList(), result);

    }

    @Test
    public void shouldFindSuperCategoriesWhenPresent() {
        Optional<Category> categoryOptional = Optional.of(category);
        List<Category> categoryList = List.of(category);
        List<CategoryData> categoryDataList = Collections.singletonList(categoryData);

        when(categoryService.findById(CATEGORY_CODE)).thenReturn(categoryOptional);
        when(categoryService.findSupercategories(category)).thenReturn(categoryList);
        when(categoryConverter.convert(category)).thenReturn(categoryData);


        List<CategoryData> result = testedEntry.findSupercategories(CATEGORY_CODE);

        assertEquals(categoryDataList, result);


    }
}
