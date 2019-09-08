package com.soft.storecore.storefront.interceptor;

import com.soft.storecore.facade.category.data.CategoryData;
import com.soft.storecore.facade.category.facade.CategoryFacade;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class HeaderAttributesInterceptorTest {

    private static final String CATEGORIES_ATTRIBUTE = "categories";

    @InjectMocks
    private HeaderAttributesInterceptor testedInstance;

    @Mock
    private HttpServletRequest request;
    @Mock
    private ModelAndView modelAndView;
    @Mock
    private CategoryFacade categoryFacade;

    private List<CategoryData> categories;

    @Before
    public void setUp(){
        when(request.getMethod()).thenReturn(RequestMethod.GET.name());
        categories = Collections.singletonList(new CategoryData());
        when(categoryFacade.findAll()).thenReturn(categories);
    }

    @Test
    public void shouldNotHandleIfModelAndViewIsNull(){
        testedInstance.postHandle(request, null, null, null);

        verify(modelAndView, never()).addObject(any());
    }

    @Test
    public void shouldNotHandleIfRequestMethodPOST(){
        when(request.getMethod()).thenReturn(RequestMethod.POST.name());

        testedInstance.postHandle(request, null, null, modelAndView);

        verify(modelAndView, never()).addObject(any());
    }

    @Test
    public void shouldNotAddAttributeIfCategoriesAreEmpty(){
        when(categoryFacade.findAll()).thenReturn(Collections.emptyList());

        testedInstance.postHandle(request, null, null, modelAndView);

        verify(modelAndView, never()).addObject(any());
    }

    @Test
    public void shouldAddCategoryAttribute(){
        testedInstance.postHandle(request, null, null, modelAndView);

        verify(modelAndView).addObject(CATEGORIES_ATTRIBUTE,categories);
    }

}
