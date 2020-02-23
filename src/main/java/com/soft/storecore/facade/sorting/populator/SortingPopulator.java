package com.soft.storecore.facade.sorting.populator;

import com.soft.storecore.core.sorting.entity.Sorting;
import com.soft.storecore.facade.sorting.data.SortingData;
import com.soft.storecore.facade.util.populator.Populator;
import org.springframework.stereotype.Component;

@Component
public class SortingPopulator implements Populator<Sorting, SortingData> {

    @Override
    public void populate(Sorting sorting, SortingData sortingData) {
        sortingData.setCode(sorting.getCode());
        sortingData.setName(sorting.getName());
    }
}
