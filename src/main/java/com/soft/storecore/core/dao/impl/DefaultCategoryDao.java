package com.soft.storecore.core.dao.impl;

import com.soft.storecore.core.dao.CategoryDao;
import com.soft.storecore.core.dao.util.SessionProvider;
import com.soft.storecore.core.entity.Category;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class DefaultCategoryDao implements CategoryDao {

    private static final String FIND_ALL_QUERY = "SELECT c FROM Category c WHERE c.superCategory IS NULL";

    @Resource
    private SessionProvider sessionProvider;

    @Override
    public List<Category> findAll() {
        return sessionProvider.getSession().createQuery(FIND_ALL_QUERY, Category.class).list();
    }

    @Override
    public Category findById(Long categoryId) {
        return sessionProvider.getSession().load(Category.class, categoryId);
    }
}
