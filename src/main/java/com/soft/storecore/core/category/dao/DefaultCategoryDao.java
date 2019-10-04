package com.soft.storecore.core.category.dao;

import com.soft.storecore.core.category.entity.Category;
import com.soft.storecore.core.common.dao.SessionProvider;
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
}
