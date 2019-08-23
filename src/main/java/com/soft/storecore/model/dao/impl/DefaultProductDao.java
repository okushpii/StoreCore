package com.soft.storecore.model.dao.impl;

import com.soft.storecore.model.dao.ProductDao;
import com.soft.storecore.model.dao.util.SessionProvider;
import com.soft.storecore.model.entity.Product;
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
