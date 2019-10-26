package com.soft.storecore.core.category.dao;

import com.soft.storecore.core.category.entity.Category;
import com.soft.storecore.core.common.dao.util.SessionProvider;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Repository
public class DefaultCategoryDao implements CategoryDao {

    private static final String FIND_ALL_QUERY = "SELECT c FROM Category c WHERE c.superCategory IS NULL";
    private static final String FIND_BY_ID_QUERY = "SELECT c FROM Category c WHERE c.code = :code";

    @Resource
    private SessionProvider sessionProvider;

    @Override
    public List<Category> findAll() {
        return sessionProvider.getSession().createQuery(FIND_ALL_QUERY, Category.class).list();
    }

    @Override
    public Optional<Category> findById(String code) {
        return Optional.ofNullable(sessionProvider.getSession().createQuery(FIND_BY_ID_QUERY, Category.class)
                .setParameter("code", code).uniqueResult());
    }
}
