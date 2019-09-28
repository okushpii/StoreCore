package com.soft.storecore.storefront.breadcrumb.builder;

import com.soft.storecore.facade.category.data.CategoryData;
import com.soft.storecore.storefront.breadcrumb.pojo.Breadcrumb;
import com.soft.storecore.storefront.util.url.UrlBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CategoryBreadcrumbBuilderTest {

    private static final String FIRST_CATEGORY = "firstCategory";
    private static final String SECOND_CATEGORY = "secondCategory";

    private static final String FIRST_CATEGORY_URL = "/c/20";
    private static final String SECOND_CATEGORY_URL = "/c/30";

    @InjectMocks
    private CategoryBreadcrumbBuilder testedEntry;

    @Mock
    private CategoryData firstCategoryData;
    @Mock
    private CategoryData secondCategoryData;
    @Mock
    private UrlBuilder<CategoryData> categoryUrlBuilder;

    @Before
    public void setUp(){
        when(firstCategoryData.getName()).thenReturn(FIRST_CATEGORY);
        when(secondCategoryData.getName()).thenReturn(SECOND_CATEGORY);

        when(categoryUrlBuilder.buildUrl(firstCategoryData)).thenReturn(FIRST_CATEGORY_URL);
        when(categoryUrlBuilder.buildUrl(secondCategoryData)).thenReturn(SECOND_CATEGORY_URL);

    }

    @Test
    public void shouldbuildBreadcrumbs() {
        List<CategoryData> categoryDataList = new ArrayList<>();
        categoryDataList.add(firstCategoryData);
        categoryDataList.add(secondCategoryData);

        List<Breadcrumb> result = testedEntry.buildBreadcrumbs(categoryDataList);

        assertEquals(result.get(0).getName(), SECOND_CATEGORY);
        assertEquals(result.get(1).getName(), FIRST_CATEGORY);
        assertEquals(result.get(0).getUrl(), SECOND_CATEGORY_URL);
        assertEquals(result.get(1).getUrl(), FIRST_CATEGORY_URL);


    }
}