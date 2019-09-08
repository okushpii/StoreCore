package com.soft.storecore.core.product.dao;

import com.soft.storecore.core.product.entity.Product;

import java.util.List;

public interface ProductDao {

    List<Product> findAllByCategoryId(Long categoryId);
}
