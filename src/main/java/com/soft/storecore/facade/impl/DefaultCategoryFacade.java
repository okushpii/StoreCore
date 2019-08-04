package com.soft.storecore.facade.impl;

import com.soft.storecore.facade.CategoryFacade;
import com.soft.storecore.model.entity.Category;
import com.soft.storecore.model.service.CategoryService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class DefaultCategoryFacade implements CategoryFacade {

    @Resource
    private CategoryService categoryService;

    @Override
    public List<Category> findAll() {
        return categoryService.findAll();
    }
}
