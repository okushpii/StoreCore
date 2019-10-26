package com.soft.storecore.core.product.dao.builder;

import com.soft.storecore.core.common.dao.pojo.Query;
import com.soft.storecore.core.sorting.dao.builder.SortingQueryAppender;
import com.soft.storecore.core.sorting.entity.Sorting;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SortingQueryAppenderTest {

    private static final String BASE_QUERY = "QUERY";
    private static final String EXPECTED_QUERY = "QUERY ORDER BY p.date asc";
    private static final String SORTING_FIELD = "date";
    private static final String SORTING_TYPE = "asc";
    private static final String ALIAS = "p";

    private Query query;

    @InjectMocks
    private SortingQueryAppender testedInstance;

    @Mock
    private Sorting sorting;

    @Before
    public void setUp(){
        query = new Query(BASE_QUERY, ALIAS);
    }


    @Test
    public void shouldReturnBaseQueryWhenSortingIsAbsent(){
        Query result = testedInstance.appendQuery(query, null);

        assertEquals(BASE_QUERY, result.getQuery());
    }

    @Test
    public void shouldBuildQuery(){
        when(sorting.getField()).thenReturn(SORTING_FIELD);
        when(sorting.getType()).thenReturn(SORTING_TYPE);
        Query result = testedInstance.appendQuery(query, sorting);

        assertEquals(EXPECTED_QUERY, result.getQuery());
    }
}
