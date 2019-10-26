package com.soft.storecore.core.sorting.dao.impl;

import com.soft.storecore.core.common.dao.util.SessionProvider;
import com.soft.storecore.core.sorting.dao.SortingDao;
import com.soft.storecore.core.sorting.entity.Sorting;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Repository
public class DefaultSortingDao implements SortingDao {

    private static final String FIND_BY_CODE = "SELECT s FROM Sorting s WHERE s.code = :code";
    private static final String FIND_BY_GROUP = "SELECT s FROM Sorting s WHERE s.sortingGroup = :sortingGroup";

    @Resource
    private SessionProvider sessionProvider;

    @Override
    public Optional<Sorting> findByCode(String code) {
        return Optional.ofNullable(sessionProvider.getSession().createQuery(FIND_BY_CODE, Sorting.class)
                .setParameter("code", code).uniqueResult());
    }

    @Override
    public List<Sorting> findByGroup(String group) {
        return sessionProvider.getSession().createQuery(FIND_BY_GROUP, Sorting.class)
                .setParameter("sortingGroup", group).list();
    }
}
