package com.soft.storecore.model.service;

import com.soft.storecore.model.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAllByCategoryId(Long categoryId);
}
