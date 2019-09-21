package com.soft.storecore.core.service;

import com.soft.storecore.core.pojo.Sorting;

import java.util.Optional;

public interface SortingService {

    Optional<Sorting> getSorting(String sortingFieldKey, String sortingTypeFieldKey);
}
