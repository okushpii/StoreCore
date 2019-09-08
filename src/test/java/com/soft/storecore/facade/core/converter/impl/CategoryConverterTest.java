package com.soft.storecore.facade.core.converter.impl;

import com.soft.storecore.core.entity.Category;
import com.soft.storecore.facade.category.converter.CategoryConverter;
import com.soft.storecore.facade.category.data.CategoryData;
import com.soft.storecore.facade.category.populator.CategoryPopulator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CategoryConverterTest {

    @InjectMocks
    private CategoryConverter testedInstance;
    @Mock
    private Category category;
    @Mock
    private CategoryPopulator categoryPopulator;

    @Test
    public void shouldConvertCategory(){
        CategoryData result = testedInstance.convert(category);
        verify(categoryPopulator).populate(category, result);
    }

}
