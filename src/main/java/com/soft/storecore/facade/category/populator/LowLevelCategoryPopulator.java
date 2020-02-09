package com.soft.storecore.facade.category.populator;

import com.soft.storecore.core.category.entity.Category;
import com.soft.storecore.facade.category.data.CategoryData;
import com.soft.storecore.facade.util.converter.Converter;
import com.soft.storecore.facade.util.populator.Populator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Optional;

@Component
public class LowLevelCategoryPopulator implements Populator<Category, CategoryData> {

    @Resource
    private Converter<Category, CategoryData> lowLevelCategoryConverter;

    @Override
    public void populate(Category category, CategoryData categoryData) {
        categoryData.setCode(category.getCode());
        categoryData.setName(category.getName());
        Optional.ofNullable(category.getSuperCategory())
                .ifPresent(sc -> categoryData.setSuperCategory(lowLevelCategoryConverter.convert(sc)));
    }
}
