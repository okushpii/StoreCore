package com.soft.storecore.facade.populator;

import com.soft.storecore.core.entity.Category;
import com.soft.storecore.facade.data.CategoryData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CategoryPopulatorTest {

    private static final long CATEGORY_ID = 10L;
    private static final String CATEGORY_NAME = "categoryName";

    @InjectMocks
    private CategoryPopulator testedInstance;

    @Mock
    private Category category;
    @Mock
    private Category superCategory;

    @Test
    public void shouldPopulateCategoryData(){
        CategoryData categoryData = new CategoryData();

        prepareCategory();
        testedInstance.populate(category, categoryData);

        assertEquals(String.valueOf(CATEGORY_ID), categoryData.getId().toString());
        assertEquals(CATEGORY_NAME, categoryData.getName());
        assertEquals(Collections.emptyList(), categoryData.getChildCategories());
        assertEquals(superCategory, categoryData.getSuperCategory());
    }

    private void prepareCategory() {
        when(category.getId()).thenReturn(CATEGORY_ID);
        when(category.getName()).thenReturn(CATEGORY_NAME);
        when(category.getChildCategories()).thenReturn(Collections.emptyList());
        when(category.getSuperCategory()).thenReturn(superCategory);
    }

}