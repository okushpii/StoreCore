package com.soft.storecore.facade.impl;

import com.soft.storecore.core.entity.Category;
import com.soft.storecore.core.service.CategoryService;
import com.soft.storecore.facade.CategoryFacade;
import com.soft.storecore.facade.converter.Converter;
import com.soft.storecore.facade.data.CategoryData;
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
