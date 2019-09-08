package com.soft.storecore.facade.category.converter;

import com.soft.storecore.core.entity.Category;
import com.soft.storecore.facade.category.data.CategoryData;
import com.soft.storecore.facade.core.converter.Converter;
import com.soft.storecore.facade.core.populator.Populator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class CategoryConverter implements Converter<Category, CategoryData> {

    @Resource
    private Populator<Category, CategoryData> categoryPopulator;

    @Override
    public CategoryData convert(Category category) {
        CategoryData categoryData = new CategoryData();
        categoryPopulator.populate(category, categoryData);
        return categoryData;
    }
}
