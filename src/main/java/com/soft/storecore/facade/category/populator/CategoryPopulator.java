package com.soft.storecore.facade.category.populator;

import com.soft.storecore.core.category.entity.Category;
import com.soft.storecore.facade.category.data.CategoryData;
import com.soft.storecore.facade.util.populator.Populator;
import org.springframework.stereotype.Component;

@Component
public class CategoryPopulator implements Populator<Category, CategoryData> {

    @Override
    public void populate(Category category, CategoryData categoryData) {
        categoryData.setCode(category.getCode());
        categoryData.setName(category.getName());
        categoryData.setSuperCategory(category.getSuperCategory());
        categoryData.setChildCategories(category.getChildCategories());
    }
}
