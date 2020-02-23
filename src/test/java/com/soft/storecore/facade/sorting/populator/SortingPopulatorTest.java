package com.soft.storecore.facade.sorting.populator;

import com.soft.storecore.core.sorting.entity.Sorting;
import com.soft.storecore.facade.sorting.data.SortingData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SortingPopulatorTest {

    private static final String SORTING_CODE = "prd-date-asc";
    private static final String SORTING_NAME = "Date asc";

    @InjectMocks
    private SortingPopulator testedInstance;

    @Mock
    private Sorting sorting;

    @Test
    public void shouldPopulate(){
        SortingData sortingData = new SortingData();

        prepareSorting();
        testedInstance.populate(sorting, sortingData);

        assertFields(sortingData);
    }

    private void assertFields(SortingData sortingData) {
        assertEquals(SORTING_CODE, sortingData.getCode());
        assertEquals(SORTING_NAME, sortingData.getName());
    }

    private void prepareSorting() {
        when(sorting.getCode()).thenReturn(SORTING_CODE);
        when(sorting.getName()).thenReturn(SORTING_NAME);
    }
}
