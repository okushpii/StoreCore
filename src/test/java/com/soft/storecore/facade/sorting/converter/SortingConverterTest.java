package com.soft.storecore.facade.sorting.converter;

import com.soft.storecore.core.sorting.entity.Sorting;
import com.soft.storecore.facade.sorting.data.SortingData;
import com.soft.storecore.facade.util.populator.Populator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SortingConverterTest {

    @InjectMocks
    private SortingConverter testedInstance;

    @Mock
    private Populator<Sorting, SortingData> sortingPopulator;
    @Mock
    private Sorting sorting;

    @Test
    public void shouldConvert(){
        SortingData result = testedInstance.convert(sorting);

        verify(sortingPopulator).populate(sorting,result);
    }
}
