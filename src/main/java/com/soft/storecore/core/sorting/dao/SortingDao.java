package com.soft.storecore.core.sorting.dao;

import com.soft.storecore.core.sorting.entity.Sorting;

import java.util.List;
import java.util.Optional;

public interface SortingDao {

    Optional<Sorting> findByCode(String code);

    List<Sorting> findByGroup(String group);
}
