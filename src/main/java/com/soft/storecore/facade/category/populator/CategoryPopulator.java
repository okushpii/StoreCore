package com.soft.storecore.facade.category.populator;

import com.soft.storecore.core.entity.Category;
import com.soft.storecore.facade.category.data.CategoryData;
import com.soft.storecore.facade.core.populator.Populator;
import org.springframework.stereotype.Component;

@Component
public class CategoryPopulator implements Populator<Category, CategoryData> {

    @Override
    public void populate(Category category, CategoryData categoryData) {
        categoryData.setId(category.getId());
        categoryData.setName(category.getName());
        categoryData.setSuperCategory(category.getSuperCategory());
        categoryData.setChildCategories(category.getChildCategories());
    }
}
