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
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultSortingServiceTest {

    private static final String SORTING_CODE = "prd-date-asc";
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
    }

    @Test
    public void shouldReturnSorting(){
        when(sortingDao.findByCode(SORTING_CODE)).thenReturn(Optional.of(firstSorting));
        Optional<Sorting> result = testedInstance.find(SORTING_CODE);

        assertEquals(Optional.of(firstSorting), result);
    }

    @Test
    public void shouldReturnSortingList(){
        List<Sorting> result = testedInstance.findByGroup(SORTING_GROUP);

        assertEquals(List.of(firstSorting, secondSorting), result);
    }
}
