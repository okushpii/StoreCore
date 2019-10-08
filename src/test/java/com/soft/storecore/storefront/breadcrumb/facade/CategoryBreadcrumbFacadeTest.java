package com.soft.storecore.storefront.breadcrumb.facade;

import com.soft.storecore.facade.category.data.CategoryData;
import com.soft.storecore.facade.category.facade.CategoryFacade;
import com.soft.storecore.storefront.breadcrumb.builder.BreadcrumbBuilder;
import com.soft.storecore.storefront.breadcrumb.pojo.Breadcrumb;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CategoryBreadcrumbFacadeTest {

    private static final String CATEGORY_CODE = "23";

    @InjectMocks
    private CategoryBreadcrumbFacade testedEntry;

    @Mock
    private CategoryFacade categoryFacade;

    @Mock
    private BreadcrumbBuilder<CategoryData> categoryBreadcrumbBuilder;

    @Mock
    private CategoryData categoryData;

    @Mock
    private Breadcrumb breadcrumb;

    @Test
    public void shouldGetBreadcrumbs(){
        List<CategoryData> categories = List.of(categoryData);
        List<Breadcrumb> breadcrumbList = List.of(breadcrumb);

        when(categoryBreadcrumbBuilder.buildBreadcrumbs(categories)).thenReturn(breadcrumbList);
        when(categoryFacade.findSupercategories(CATEGORY_CODE)).thenReturn(categories);
        List<Breadcrumb> result = testedEntry.getBreadcrumbs(CATEGORY_CODE);

        assertEquals(breadcrumbList, result);
    }
}