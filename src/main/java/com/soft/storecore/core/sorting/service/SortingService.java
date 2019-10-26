package com.soft.storecore.core.sorting.service;

import com.soft.storecore.core.sorting.entity.Sorting;

import java.util.List;
import java.util.Optional;

public interface SortingService {

    List<Sorting> findAllGrouped(String group, String currentSorting);

    Optional<Sorting> find(String code);
}
