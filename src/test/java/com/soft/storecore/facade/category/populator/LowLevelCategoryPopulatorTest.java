package com.soft.storecore.facade.category.populator;

import com.soft.storecore.core.category.entity.Category;
import com.soft.storecore.facade.category.data.CategoryData;
import com.soft.storecore.facade.util.converter.Converter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LowLevelCategoryPopulatorTest {

    private static final String CATEGORY_CODE = "CAT-8";
    private static final String CATEGORY_NAME = "Category";
    @InjectMocks
    private LowLevelCategoryPopulator testedInstance;

    @Mock
    private Converter<Category, CategoryData> lowLevelCategoryConverter;
    @Mock
    private Category source;
    @Mock
    private Category topCategory;

    @Test
    public void shouldPopulate(){
        CategoryData target = new CategoryData();
        CategoryData topCategoryData = new CategoryData();

        when(source.getCode()).thenReturn(CATEGORY_CODE);
        when(source.getName()).thenReturn(CATEGORY_NAME);
        when(source.getSuperCategory()).thenReturn(topCategory);
        when(lowLevelCategoryConverter.convert(topCategory)).thenReturn(topCategoryData);
        testedInstance.populate(source, target);

        assertEquals(target.getCode(), CATEGORY_CODE);
        assertEquals(target.getName(), CATEGORY_NAME);
        assertEquals(target.getSuperCategory(), topCategoryData);
    }
}