package com.soft.storecore.facade.sorting.facade.impl;

import com.soft.storecore.core.sorting.entity.Sorting;
import com.soft.storecore.core.sorting.service.SortingService;
import com.soft.storecore.facade.sorting.data.SortingData;
import com.soft.storecore.facade.util.converter.Converter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultSortingFacadeTest {

    private static final String SORTING_GROUP_KEY = "sorting.product";

    @InjectMocks
    private DefaultSortingFacade testedInstance;

    @Mock
    private Converter<Sorting, SortingData> sortingConverter;
    @Mock
    private SortingService sortingService;
    @Mock
    private Sorting sorting;

    @Test
    public void shouldReturnSortingList(){
        List<Sorting> sortingList = List.of(sorting);
        List<SortingData> sortingDataList = List.of(new SortingData());

        when(sortingService.findByGroup(SORTING_GROUP_KEY)).thenReturn(sortingList);
        when(sortingConverter.convertAll(sortingList)).thenReturn(sortingDataList);
        List<SortingData> result = testedInstance.find(SORTING_GROUP_KEY);

        assertEquals(sortingDataList, result);
    }
}
