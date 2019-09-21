package com.soft.storecore.core.product.service;

import com.soft.storecore.core.category.entity.Category;
import com.soft.storecore.core.category.service.CategoryService;
import com.soft.storecore.core.pojo.Sorting;
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
        return productDao.findAllByCategoryId(categoryId);
    }

    @Override
    public List<Product> findAllByCategoryId(Long categoryId, Sorting sorting) {
        Category category = categoryService.findById(categoryId);

        if (category.getChildCategories().isEmpty()){
            return productDao.findAllByCategoryId(categoryId, sorting);
        }
        return findForChildCategories(category, sorting);
    }

    private List<Product> findForChildCategories(Category category, Sorting sorting) {
        return category.getChildCategories().stream()
                .flatMap(cc -> productDao.findAllByCategoryId(cc.getId(), sorting).stream())
                .collect(Collectors.toList());
    }
}
