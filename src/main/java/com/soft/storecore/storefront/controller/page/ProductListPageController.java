package com.soft.storecore.storefront.controller.page;


import com.soft.storecore.facade.media.ImageFormatFacade;
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

    private static final String IMAGE_FORMAT_KEY = "media.product.list.image.format";
    private static final String DEFAULT_IMAGE_FORMAT = "730x560";

    @Resource
    private ProductFacade productFacade;
    @Resource
    private BreadcrumbFacade categoryBreadcrumbFacade;
    @Resource
    private ImageFormatFacade imageFormatFacade;

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
        model.addAttribute(Attributes.IMAGE_FORMAT, imageFormatFacade
                .getFormat(IMAGE_FORMAT_KEY, DEFAULT_IMAGE_FORMAT));
        return Pages.PRODUCT_LIST_PAGE;
    }
}
