package com.soft.storecore.core.category.service;

import com.soft.storecore.core.category.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> findAll();

    List<Category> findSupercategories(Category category);

    Optional<Category> findById(Long id);
}
