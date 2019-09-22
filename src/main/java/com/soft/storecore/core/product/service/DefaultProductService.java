package com.soft.storecore.core.product.service;

import com.soft.storecore.core.product.dao.ProductDao;
import com.soft.storecore.core.product.entity.Product;
import com.soft.storecore.core.sorting.pojo.SortingData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DefaultProductService implements ProductService {

    @Resource
    private ProductDao productDao;

    @Override
    public List<Product> findAllByCategoryId(Long categoryId, SortingData sortingData) {
        return productDao.findAllByCategoryId(categoryId, sortingData);
    }

}
