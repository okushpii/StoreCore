package com.soft.storecore.core.sorting.service;

import com.soft.storecore.core.sorting.entity.Sorting;

import java.util.List;
import java.util.Optional;

public interface SortingService {

    List<Sorting> findByGroup(String group);

    Optional<Sorting> find(String code);
}
