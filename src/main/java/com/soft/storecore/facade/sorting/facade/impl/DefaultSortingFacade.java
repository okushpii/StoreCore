package com.soft.storecore.facade.sorting.facade.impl;

import com.soft.storecore.core.sorting.entity.Sorting;
import com.soft.storecore.core.sorting.service.SortingService;
import com.soft.storecore.facade.sorting.data.SortingData;
import com.soft.storecore.facade.sorting.facade.SortingFacade;
import com.soft.storecore.facade.util.converter.Converter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class DefaultSortingFacade implements SortingFacade {

    @Resource
    private SortingService sortingService;
    @Resource
    private Converter<Sorting, SortingData> sortingConverter;

    @Override
    public List<SortingData> find(String group) {
        return sortingConverter.convertAll(sortingService.findByGroup(group));
    }
}
