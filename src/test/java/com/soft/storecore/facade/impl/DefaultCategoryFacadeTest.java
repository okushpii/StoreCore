package com.soft.storecore.facade.impl;

import com.soft.storecore.core.category.entity.Category;
import com.soft.storecore.core.category.service.CategoryService;
import com.soft.storecore.facade.category.converter.CategoryConverter;
import com.soft.storecore.facade.category.converter.LowLevelCategoryConverter;
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

    private static final String CATEGORY_CODE = "CAT-8";

    @InjectMocks
    private DefaultCategoryFacade testedEntry;

    @Mock
    private CategoryService categoryService;
    @Mock
    private Category category;
    @Mock
    private CategoryConverter categoryConverter;
    @Mock
    private LowLevelCategoryConverter lowLevelCategoryConverter;

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
    public void shouldFindCategory(){
        CategoryData categoryData = new CategoryData();

        when(categoryService.findById(CATEGORY_CODE)).thenReturn(Optional.of(category));
        when(lowLevelCategoryConverter.convert(category)).thenReturn(categoryData);
        Optional<CategoryData> result = testedEntry.find(CATEGORY_CODE);

        assertEquals(Optional.of(categoryData), result);

    }
}
