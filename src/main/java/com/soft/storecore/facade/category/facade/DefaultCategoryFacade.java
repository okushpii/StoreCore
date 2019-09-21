package com.soft.storecore.facade.category.facade;

import com.soft.storecore.core.category.entity.Category;
import com.soft.storecore.core.category.service.CategoryService;
import com.soft.storecore.facade.category.data.CategoryData;
import com.soft.storecore.facade.util.converter.Converter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DefaultCategoryFacade implements CategoryFacade {

    @Resource
    private CategoryService categoryService;

    @Resource
    private Converter<Category, CategoryData> categoryConverter;

    @Override
    public List<CategoryData> findAll() {
        return categoryService.findAll().stream()
                .map(c -> categoryConverter.convert(c))
                .collect(Collectors.toList());
    }
}