package com.soft.storecore.model.dao;

import com.soft.storecore.model.entity.Product;

import java.util.List;

public interface ProductDao {

    List<Product> findAllByCategoryId(Long categoryId);
}
