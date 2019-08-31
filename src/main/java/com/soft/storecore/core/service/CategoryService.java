package com.soft.storecore.core.service;

import com.soft.storecore.core.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(Long categoryId);
}
