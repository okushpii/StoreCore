package com.soft.storecore.model.service.impl;

import com.soft.storecore.model.dao.ProductDao;
import com.soft.storecore.model.entity.Product;
import com.soft.storecore.model.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DefaultProductService implements ProductService {

    @Resource
    private ProductDao productDao;

    @Override
    public List<Product> findAllByCategoryId(Long categoryId) {
        return productDao.findAllByCategoryId(categoryId);
    }
}
