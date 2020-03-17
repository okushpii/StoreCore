package com.soft.storecore.core.product.dao;

import com.soft.storecore.core.common.dao.builder.QueryAppender;
import com.soft.storecore.core.common.dao.pojo.Query;
import com.soft.storecore.core.common.dao.util.SessionProvider;
import com.soft.storecore.core.product.entity.Product;
import com.soft.storecore.core.sorting.entity.Sorting;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class DefaultProductDao implements ProductDao {

    private static final String FIND_ALL_BY_CATEGORY_QUERY = "SELECT p FROM Product p INNER JOIN p.category c" +
            " LEFT JOIN c.superCategory sc" +
            " WHERE c.code = :category OR sc.code = :category";

    private static final String PRODUCT_ALIAS = "p";

    @Resource
    private SessionProvider sessionProvider;
    @Resource
    private QueryAppender<Sorting> sortingQueryAppender;

    @Override
    public List<Product> findAllByCategory(String categoryCode, Sorting sorting,
                                           int start, int pageSize) {
        Query query = new Query(FIND_ALL_BY_CATEGORY_QUERY, PRODUCT_ALIAS);

        Query resultQuery = sortingQueryAppender.appendQuery(query, sorting);

        return sessionProvider.getSession().createQuery(resultQuery.getQuery(), Product.class)
                .setParameter("category", categoryCode).setFirstResult(start)
                .setMaxResults(pageSize).list();
    }
}
