package com.soft.storecore.core.sorting.service.impl;

import com.soft.storecore.core.sorting.dao.SortingDao;
import com.soft.storecore.core.sorting.entity.Sorting;
import com.soft.storecore.core.sorting.service.SortingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultSortingService implements SortingService {

    @Resource
    private SortingDao sortingDao;

    @Override
    public List<Sorting> findByGroup(String group) {
        return sortingDao.findByGroup(group);
    }

    @Override
    public Optional<Sorting> find(String code) {
        return sortingDao.findByCode(code);
    }
}
