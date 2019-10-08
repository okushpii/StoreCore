package com.soft.storecore.core.product.service;

import com.soft.storecore.core.product.entity.Product;
import com.soft.storecore.core.sorting.pojo.SortingData;

import java.util.List;

public interface ProductService {

    List<Product> findAllByCategory(String categoryCode, SortingData sortingData);
}
