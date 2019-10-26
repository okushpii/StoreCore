package com.soft.storecore.core.sorting.service.impl;

import com.soft.storecore.core.sorting.dao.SortingDao;
import com.soft.storecore.core.sorting.entity.Sorting;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultSortingServiceTest {

    private static final String SORTING_CODE = "prd-date-asc";
    private static final String FIRST_SORTING_CODE = "prd-price-asc";
    private static final String SECOND_SORTING_CODE = "prd-price-desc";
    private static final String SORTING_GROUP = "product";

    @InjectMocks
    private DefaultSortingService testedInstance;

    @Mock
    private SortingDao sortingDao;
    @Mock
    private Sorting firstSorting;
    @Mock
    private Sorting secondSorting;

    @Before
    public void setUp(){
        when(sortingDao.findByGroup(SORTING_GROUP)).thenReturn(List.of(firstSorting, secondSorting));
        when(firstSorting.getCode()).thenReturn(FIRST_SORTING_CODE);
        when(secondSorting.getCode()).thenReturn(SECOND_SORTING_CODE);
    }

    @Test
    public void shouldReturnSorting(){
        when(sortingDao.findByCode(SORTING_CODE)).thenReturn(Optional.of(firstSorting));
        Optional<Sorting> result = testedInstance.find(SORTING_CODE);

        assertEquals(Optional.of(firstSorting), result);
    }

    @Test
    public void shouldMarkFirstSelectedWhenNoCurrentSorting(){
        testedInstance.findAllGrouped(SORTING_GROUP, SORTING_CODE);

        verify(firstSorting).setSelected(true);
    }

    @Test
    public void shouldMarkSelectedIfSelectedCurrentSorting(){
        testedInstance.findAllGrouped(SORTING_GROUP, SECOND_SORTING_CODE);

        verify(secondSorting).setSelected(true);
    }

    @Test
    public void shouldReturnSortingList(){
        List<Sorting> result = testedInstance.findAllGrouped(SORTING_GROUP, SECOND_SORTING_CODE);

        assertEquals(List.of(firstSorting, secondSorting), result);
    }
}
