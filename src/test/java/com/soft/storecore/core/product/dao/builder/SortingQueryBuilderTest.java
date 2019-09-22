package com.soft.storecore.core.product.dao.builder;

import com.soft.storecore.core.sorting.pojo.SortingData;
import com.soft.storecore.core.sorting.pojo.SortingField;
import com.soft.storecore.core.sorting.pojo.SortingType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SortingQueryBuilderTest {

    private static final String BASE_QUERY = "QUERY";
    private static final String EXPECTED_QUERY = "QUERY ORDER BY p.field ASC";
    private static final String SORTING_FIELD = "p.field";
    private static final String SORTING_TYPE = "ASC";

    @InjectMocks
    private SortingQueryBuilder testedInstance;

    @Mock
    private Map<SortingField, String> daoSortingFieldMap;
    @Mock
    private Map<SortingType, String> daoSortingTypeMap;

    @Test
    public void shouldReturnBaseQueryWhenSortingIsAbsent(){
        String result = testedInstance.buildQuery(BASE_QUERY, null);

        assertEquals(BASE_QUERY, result);
    }

    @Test
    public void shouldBuildQuery(){
        SortingData sortingData = new SortingData(SortingField.PRICE, SortingType.ASC);

        when(daoSortingFieldMap.get(sortingData.getSortingField())).thenReturn(SORTING_FIELD);
        when(daoSortingTypeMap.get(sortingData.getSortingType())).thenReturn(SORTING_TYPE);
        String result = testedInstance.buildQuery(BASE_QUERY, sortingData);

        assertEquals(EXPECTED_QUERY, result);
    }
}
