package com.soft.storecore.facade.category.facade;

import com.soft.storecore.core.category.entity.Category;
import com.soft.storecore.core.category.service.CategoryService;
import com.soft.storecore.facade.category.data.CategoryData;
import com.soft.storecore.facade.util.converter.Converter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Component
public class DefaultCategoryFacade implements CategoryFacade {

    @Resource
    private CategoryService categoryService;
    @Resource
    private Converter<Category, CategoryData> categoryConverter;
    @Resource
    private Converter<Category, CategoryData> lowLevelCategoryConverter;

    @Override
    public List<CategoryData> findAll() {
        return categoryConverter.convertAll(categoryService.findAll());
    }

    @Override
    public Optional<CategoryData> find(String code) {
        return categoryService.findById(code).map(c -> lowLevelCategoryConverter.convert(c));
    }
}
