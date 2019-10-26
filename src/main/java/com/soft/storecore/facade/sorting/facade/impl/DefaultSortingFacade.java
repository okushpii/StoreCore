package com.soft.storecore.facade.sorting.facade.impl;

import com.soft.storecore.core.config.service.ConfigurationService;
import com.soft.storecore.core.sorting.entity.Sorting;
import com.soft.storecore.core.sorting.service.SortingService;
import com.soft.storecore.facade.sorting.data.SortingData;
import com.soft.storecore.facade.sorting.facade.SortingFacade;
import com.soft.storecore.facade.util.converter.Converter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Component
public class DefaultSortingFacade implements SortingFacade {

    @Resource
    private SortingService sortingService;
    @Resource
    private Converter<Sorting, SortingData> sortingConverter;
    @Resource
    private ConfigurationService configurationService;

    @Override
    public List<SortingData> find(String group, String currentSorting) {
        return configurationService.findConfiguration(group)
                .map(c ->  sortingConverter.convertAll(sortingService.findAllGrouped(c, currentSorting)))
                .orElse(Collections.emptyList());
    }
}
