package com.soft.storecore.storefront.util.url;

import com.soft.storecore.facade.category.data.CategoryData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class CategoryUrlBuilderTest {

    private static final long CATEGORY_ID = 23L;

    @InjectMocks
    private CategoryUrlBuilder testedEntry;

    @Mock
    private CategoryData model;

    @Test
    public void shouldBuildUrl() {
        String expected = "/productList/" + CATEGORY_ID;

        when(model.getId()).thenReturn(CATEGORY_ID);
        String result = testedEntry.buildUrl(model);

        assertEquals(expected, result);
    }
}