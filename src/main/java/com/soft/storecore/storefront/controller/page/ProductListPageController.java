package com.soft.storecore.storefront.controller.page;


import com.soft.storecore.facade.product.facade.ProductFacade;
import com.soft.storecore.storefront.breadcrumb.facade.BreadcrumbFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

import static com.soft.storecore.storefront.config.StorefrontConstants.*;

@Controller
public class ProductListPageController {

    @Resource
    private ProductFacade productFacade;
    @Resource
    private BreadcrumbFacade categoryBreadcrumbFacade;

    @GetMapping(RequestMappings.PRODUCTS_BY_CATEGORY + "/{code}")
    public String getByCategory(@PathVariable String code, Model model,
                                @RequestParam(required = false, defaultValue = "placementDate")
                                        String sortingField,
                                @RequestParam(required = false, defaultValue = "asc"
                                ) String sortingType) {

        model.addAttribute(Attributes.PRODUCT_LIST, productFacade
                .findAllByCategory(code, sortingField, sortingType));
        model.addAttribute(Attributes.CATEGORY_CODE, code);
        model.addAttribute(Attributes.SORTING_FIELD, sortingField);
        model.addAttribute(Attributes.SORTING_TYPE, sortingType);
        model.addAttribute(Attributes.BREADCRUMBS, categoryBreadcrumbFacade.getBreadcrumbs(code));
        return Pages.PRODUCT_LIST_PAGE;
    }
}
