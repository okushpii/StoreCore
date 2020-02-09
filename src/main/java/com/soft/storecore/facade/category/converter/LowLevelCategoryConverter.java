package com.soft.storecore.facade.category.converter;

import com.soft.storecore.core.category.entity.Category;
import com.soft.storecore.facade.category.data.CategoryData;
import com.soft.storecore.facade.util.converter.impl.AbstractConverter;
import com.soft.storecore.facade.util.populator.Populator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class LowLevelCategoryConverter extends AbstractConverter<Category, CategoryData> {

    @Resource
    private Populator<Category, CategoryData> lowLevelCategoryPopulator;

    @Override
    public CategoryData convert(Category category) {
        CategoryData categoryData = new CategoryData();
        lowLevelCategoryPopulator.populate(category, categoryData);
        return categoryData;
    }
}
