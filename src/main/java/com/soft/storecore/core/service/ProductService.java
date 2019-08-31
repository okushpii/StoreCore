package com.soft.storecore.core.service;

import com.soft.storecore.core.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAllByCategoryId(Long categoryId);
}
