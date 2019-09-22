package com.soft.storecore.core.sorting.impl;

import com.soft.storecore.core.sorting.pojo.SortingData;
import com.soft.storecore.core.sorting.pojo.SortingField;
import com.soft.storecore.core.sorting.pojo.SortingType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultSortingServiceTest {

    private static final String SORTING_FIELD = "price";
    private static final String SORING_TYPE = "asc";

    @InjectMocks
    private DefaultSortingService testedInstance;

    @Mock
    private Map<String, SortingField> sortingFieldMap;
    @Mock
    private Map<String, SortingType> sortingTypeMap;

    @Before
    public void setUp() {
        when(sortingFieldMap.get(SORTING_FIELD)).thenReturn(SortingField.PRICE);
        when(sortingTypeMap.get(SORING_TYPE)).thenReturn(SortingType.ASC);
    }

    @Test
    public void shouldReturnNullWhenNoSortingFieldFound() {
        when(sortingFieldMap.get(SORTING_FIELD)).thenReturn(null);
        SortingData result = testedInstance.getSorting(SORTING_FIELD, SORING_TYPE);

        assertNull(result);
    }

    @Test
    public void shouldReturnNullWhenNoSortingTypeFound(){
        when(sortingTypeMap.get(SORING_TYPE)).thenReturn(null);
        SortingData result = testedInstance.getSorting(SORTING_FIELD, SORING_TYPE);

        assertNull(result);
    }

    @Test
    public void shouldReturnSortingData(){
        SortingData result = testedInstance.getSorting(SORTING_FIELD, SORING_TYPE);

        assertEquals(SortingField.PRICE, result.getSortingField());
        assertEquals(SortingType.ASC, result.getSortingType());
    }

}