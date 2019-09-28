package com.soft.storecore.core.category.dao;

import com.soft.storecore.core.category.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryDao {

    List<Category> findAll();

    Optional<Category> findById(Long id);
}
