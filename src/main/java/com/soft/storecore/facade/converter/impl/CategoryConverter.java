package com.soft.storecore.facade.converter.impl;

import com.soft.storecore.facade.converter.Converter;
import com.soft.storecore.facade.data.CategoryData;
import com.soft.storecore.facade.populator.Populator;
import com.soft.storecore.model.entity.Category;
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
