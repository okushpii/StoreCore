package com.soft.storecore.core.dao;

import com.soft.storecore.core.entity.Product;

import java.util.List;

public interface ProductDao {

    List<Product> findAllByCategoryId(Long categoryId);
}
