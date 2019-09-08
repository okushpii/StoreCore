package com.soft.storecore.core.product.service;

import com.soft.storecore.core.category.entity.Category;
import com.soft.storecore.core.category.service.CategoryService;
import com.soft.storecore.core.product.dao.ProductDao;
import com.soft.storecore.core.product.entity.Product;
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
