package com.soft.storecore.core.dao;

import com.soft.storecore.core.entity.Category;

import java.util.List;

public interface CategoryDao {

    List<Category> findAll();

    Category findById(Long categoryId);
}
