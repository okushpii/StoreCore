package com.soft.storecore.core.product.dao;

import com.soft.storecore.core.product.entity.Product;
import com.soft.storecore.core.util.SessionProvider;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class DefaultProductDao implements ProductDao {

    private static final String FIND_ALL_BY_CATEGORY_QUERY = "SELECT p FROM Product p WHERE p.category.id = :category ";

    @Resource
    private SessionProvider sessionProvider;

    @Override
    public List<Product> findAllByCategoryId(Long categoryId) {
       return sessionProvider.getSession().createQuery(FIND_ALL_BY_CATEGORY_QUERY, Product.class)
               .setParameter("category", categoryId).list();
    }
}