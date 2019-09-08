package com.soft.storecore.core.product.service;

import com.soft.storecore.core.product.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAllByCategoryId(Long categoryId);
}
