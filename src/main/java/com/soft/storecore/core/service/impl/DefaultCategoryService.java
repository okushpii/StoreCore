package com.soft.storecore.core.service.impl;

import com.soft.storecore.core.dao.CategoryDao;
import com.soft.storecore.core.entity.Category;
import com.soft.storecore.core.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DefaultCategoryService implements CategoryService {

    @Resource
    private CategoryDao categoryDao;

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public Category findById(Long categoryId) {
        return categoryDao.findById(categoryId);
    }
}
