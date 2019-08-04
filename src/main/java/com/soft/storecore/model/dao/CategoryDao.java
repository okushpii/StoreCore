package com.soft.storecore.model.dao;

import com.soft.storecore.model.entity.Category;

import java.util.List;

public interface CategoryDao {

    List<Category> findAll();
}
