package com.soft.storecore.core.category.service;

import com.soft.storecore.core.category.dao.CategoryDao;
import com.soft.storecore.core.category.entity.Category;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    public List<Category> findSupercategories(Category category) {
        Category currentCategory = category;
        List<Category> supercategories = new ArrayList<>();
        supercategories.add(currentCategory);

        while (currentCategory.getSuperCategory() != null){
            currentCategory = currentCategory.getSuperCategory();
            supercategories.add(currentCategory);
        }

        return supercategories;
    }

    @Override
    public Optional<Category> findById(String code) {
        return categoryDao.findById(code);
    }
}
