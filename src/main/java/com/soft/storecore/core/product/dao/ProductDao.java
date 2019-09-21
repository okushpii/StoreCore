package com.soft.storecore.core.product.dao;

import com.soft.storecore.core.product.entity.Product;
import com.soft.storecore.core.pojo.Sorting;

import java.util.List;

public interface ProductDao {

    List<Product> findAllByCategoryId(Long categoryId);

    List<Product> findAllByCategoryId(Long categoryId, Sorting sorting);
}
