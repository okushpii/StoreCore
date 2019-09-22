package com.soft.storecore.core.product.dao;

import com.soft.storecore.core.dao.QueryBuilder;
import com.soft.storecore.core.dao.SessionProvider;
import com.soft.storecore.core.product.entity.Product;
import com.soft.storecore.core.sorting.pojo.SortingData;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class DefaultProductDao implements ProductDao {

    private static final String FIND_ALL_BY_CATEGORY_QUERY = "SELECT p FROM Product p JOIN p.category c" +
            " WHERE c.id = :category OR  c.superCategory.id = :category";

    @Resource
    private SessionProvider sessionProvider;
    @Resource
    private QueryBuilder<SortingData> sortingQueryBuilder;

    @Override
    public List<Product> findAllByCategoryId(Long categoryId, SortingData sortingData) {
        String resultQuery = sortingQueryBuilder.buildQuery(FIND_ALL_BY_CATEGORY_QUERY, sortingData);
        return sessionProvider.getSession().createQuery(resultQuery, Product.class)
                .setParameter("category", categoryId).list();
    }
}
