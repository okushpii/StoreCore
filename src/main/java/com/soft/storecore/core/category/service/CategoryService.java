package com.soft.storecore.core.category.service;

import com.soft.storecore.core.category.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(Long categoryId);
}
