package com.soft.storecore.facade.sorting.facade;

import com.soft.storecore.facade.sorting.data.SortingData;

import java.util.List;

public interface SortingFacade {

    List<SortingData> find(String group);
}
