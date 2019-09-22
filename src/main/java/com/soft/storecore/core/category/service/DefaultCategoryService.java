package com.soft.storecore.core.category.service;

import com.soft.storecore.core.category.dao.CategoryDao;
import com.soft.storecore.core.category.entity.Category;
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
}
