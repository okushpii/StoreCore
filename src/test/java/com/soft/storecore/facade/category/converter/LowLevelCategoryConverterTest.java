package com.soft.storecore.facade.category.converter;

import com.soft.storecore.core.category.entity.Category;
import com.soft.storecore.facade.category.data.CategoryData;
import com.soft.storecore.facade.util.populator.Populator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LowLevelCategoryConverterTest {

    @InjectMocks
    private LowLevelCategoryConverter testedInstance;

    @Mock
    private Populator<Category, CategoryData> lowLevelCategoryPopulator;
    @Mock
    private Category source;

    @Test
    public void shouldConvert() {
        CategoryData target = testedInstance.convert(source);

        verify(lowLevelCategoryPopulator).populate(source, target);
    }
}