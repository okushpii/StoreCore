package com.soft.storecore.model.service.impl;

import com.soft.storecore.model.dao.CategoryDao;
import com.soft.storecore.model.entity.Category;
import com.soft.storecore.model.service.CategoryService;
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
