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

    @Override
    public List<Product> findAllByCategoryId(Long categoryId, Sorting sorting) {
        String result = FIND_ALL_BY_CATEGORY_QUERY + getSortingQuery(sorting);

        return sessionProvider.getSession().createQuery(result, Product.class)
                .setParameter("category", categoryId).list();
    }

    private String getSortingQuery(Sorting sorting){
        return "ORDER BY p." + sorting.getSortingField().name() + sorting.getSortingType().name();
    }
}
