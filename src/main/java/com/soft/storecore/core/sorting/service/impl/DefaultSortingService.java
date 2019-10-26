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
    public List<Sorting> findAllGrouped(String group, String currentSorting) {
        return getSortingListWithSelected(sortingDao.findByGroup(group), currentSorting);
    }

    private List<Sorting> getSortingListWithSelected(List<Sorting> sortingList, String currentSorting) {
        sortingList.stream().filter(s -> isSortingIsCurrent(currentSorting, s))
                .findFirst().ifPresentOrElse(this::markSelected,
                () -> sortingList.stream().findFirst().ifPresent(this::markSelected));

        return sortingList;
    }

    private boolean isSortingIsCurrent(String currentSorting, Sorting s) {
        return s.getCode().equals(currentSorting);
    }

    private void markSelected(Sorting sorting) {
        sorting.setSelected(true);
    }

    @Override
    public Optional<Sorting> find(String code) {
        return sortingDao.findByCode(code);
    }
}
