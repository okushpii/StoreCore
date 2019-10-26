package com.soft.storecore.facade.sorting.facade.impl;

import com.soft.storecore.core.config.service.ConfigurationService;
import com.soft.storecore.core.sorting.entity.Sorting;
import com.soft.storecore.core.sorting.service.SortingService;
import com.soft.storecore.facade.sorting.data.SortingData;
import com.soft.storecore.facade.util.converter.Converter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultSortingFacadeTest {

    private static final String SORTING_GROUP_KEY = "sorting.product";
    private static final String CURRENT_SORTING = "prd-date-asc";
    private static final String SORTING_GROUP_VALUE = "product";

    @InjectMocks
    private DefaultSortingFacade testedInstance;

    @Mock
    private ConfigurationService configurationService;
    @Mock
    private Converter<Sorting, SortingData> sortingConverter;
    @Mock
    private SortingService sortingService;
    @Mock
    private Sorting sorting;

    @Before
    public void setUp(){
        when(configurationService.findConfiguration(SORTING_GROUP_KEY))
                .thenReturn(Optional.of(SORTING_GROUP_VALUE));

    }

    @Test
    public void shouldReturnEmptyListWhenSortingGroupNotFound(){
        when(configurationService.findConfiguration(SORTING_GROUP_KEY)).thenReturn(Optional.empty());
        List<SortingData> result = testedInstance.find(SORTING_GROUP_KEY, CURRENT_SORTING);

        assertEquals(Collections.emptyList(), result);
    }

    @Test
    public void shouldReturnSortingList(){
        List<Sorting> sortingList = List.of(sorting);
        List<SortingData> sortingDataList = List.of(new SortingData());

        when(sortingService.findAllGrouped(SORTING_GROUP_VALUE, CURRENT_SORTING)).thenReturn(sortingList);
        when(sortingConverter.convertAll(sortingList)).thenReturn(sortingDataList);
        List<SortingData> result = testedInstance.find(SORTING_GROUP_KEY, CURRENT_SORTING);

        assertEquals(sortingDataList, result);
    }

}