package com.soft.storecore.core.sorting;

import com.soft.storecore.core.sorting.pojo.SortingData;

public interface SortingService {

    SortingData getSorting(String sortingFieldKey, String sortingTypeFieldKey);
}
