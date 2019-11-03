package com.soft.storecore.facade.util.populator;

import com.soft.storecore.core.category.entity.Category;
import com.soft.storecore.facade.category.data.CategoryData;
import com.soft.storecore.facade.category.populator.CategoryPopulator;
import com.soft.storecore.facade.util.converter.Converter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CategoryPopulatorTest {

    private static final String CATEGORY_CODE = "10";
    private static final String CATEGORY_NAME = "categoryName";

    @InjectMocks
    private CategoryPopulator testedInstance;

    @Mock
    private Converter<Category, CategoryData> categoryConverter;
    @Mock
    private Category category;
    @Mock
    private Category childCategory;

    private CategoryData childCategoryData;

    @Before
    public void setUp(){
        childCategoryData = new CategoryData();
    }

    @Test
    public void shouldPopulateCategoryData(){
        CategoryData categoryData = new CategoryData();

        prepareCategory();
        testedInstance.populate(category, categoryData);

        assertEquals(CATEGORY_CODE, categoryData.getCode());
        assertEquals(CATEGORY_NAME, categoryData.getName());
        assertEquals(List.of(childCategoryData), categoryData.getChildCategories());
    }

    private void prepareCategory() {
        when(category.getCode()).thenReturn(CATEGORY_CODE);
        when(category.getName()).thenReturn(CATEGORY_NAME);
        when(category.getChildCategories()).thenReturn(List.of(childCategory));
        when(categoryConverter.convertAll(List.of(childCategory))).thenReturn(List.of(childCategoryData));
    }

}