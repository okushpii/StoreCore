package com.soft.storecore.model.service.impl;

import com.soft.storecore.model.dao.ProductDao;
import com.soft.storecore.model.entity.Category;
import com.soft.storecore.model.entity.Product;
import com.soft.storecore.model.service.CategoryService;
import com.soft.storecore.model.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultProductService implements ProductService {

    @Resource
    private ProductDao productDao;
    @Resource
    private CategoryService categoryService;

    @Override
    public List<Product> findAllByCategoryId(Long categoryId) {
        Category category = categoryService.findById(categoryId);

        if (category.getChildCategories().isEmpty()){
            return productDao.findAllByCategoryId(categoryId);
        }
        return findForChildCategories(category);
    }

    private List<Product> findForChildCategories(Category category) {
        return category.getChildCategories().stream()
                .flatMap(cc -> productDao.findAllByCategoryId(cc.getId()).stream())
                .collect(Collectors.toList());
    }
}
