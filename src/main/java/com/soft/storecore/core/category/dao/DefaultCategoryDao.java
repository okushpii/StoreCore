package com.soft.storecore.core.category.dao;

import com.soft.storecore.core.category.entity.Category;
import com.soft.storecore.core.dao.SessionProvider;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Repository
public class DefaultCategoryDao implements CategoryDao {

    private static final String FIND_ALL_QUERY = "SELECT c FROM Category c WHERE c.superCategory IS NULL";
    private static final String FIND_BY_ID_QUERY = "SELECT c FROM Category c WHERE c.id = :id";

    @Resource
    private SessionProvider sessionProvider;

    @Override
    public List<Category> findAll() {
        return sessionProvider.getSession().createQuery(FIND_ALL_QUERY, Category.class).list();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return Optional.ofNullable(sessionProvider.getSession().createQuery(FIND_BY_ID_QUERY, Category.class)
                .setParameter("id", id).uniqueResult());
    }
}
