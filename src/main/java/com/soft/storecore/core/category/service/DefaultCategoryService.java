package com.soft.storecore.core.category.service;

import com.soft.storecore.core.category.dao.CategoryDao;
import com.soft.storecore.core.category.entity.Category;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultCategoryService implements CategoryService {

    @Resource
    private CategoryDao categoryDao;

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public Optional<Category> findById(String code) {
        return categoryDao.findById(code);
    }
}
