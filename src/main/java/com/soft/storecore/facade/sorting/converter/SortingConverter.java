package com.soft.storecore.facade.sorting.converter;

import com.soft.storecore.core.sorting.entity.Sorting;
import com.soft.storecore.facade.sorting.data.SortingData;
import com.soft.storecore.facade.util.converter.impl.AbstractConverter;
import com.soft.storecore.facade.util.populator.Populator;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class SortingConverter extends AbstractConverter<Sorting, SortingData> {

    @Resource
    private Populator<Sorting, SortingData> sortingPopulator;

    @Override
    public SortingData convert(Sorting sorting) {
        SortingData sortingData = new SortingData();
        sortingPopulator.populate(sorting, sortingData);
        return sortingData;
    }
}
