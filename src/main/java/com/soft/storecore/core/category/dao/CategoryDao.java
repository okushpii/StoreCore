package com.soft.storecore.core.category.dao;

import com.soft.storecore.core.category.entity.Category;

import java.util.List;

public interface CategoryDao {

    List<Category> findAll();

    Category findById(Long categoryId);
}
