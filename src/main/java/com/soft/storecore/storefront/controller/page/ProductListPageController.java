package com.soft.storecore.storefront.controller.page;


import com.soft.storecore.facade.media.ImageFormatFacade;
import com.soft.storecore.facade.product.facade.ProductFacade;
import com.soft.storecore.facade.sorting.facade.SortingFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

import static com.soft.storecore.storefront.config.StorefrontConstants.*;

@Controller
@RequestMapping("/products")
public class ProductListPageController {

    @Resource
    private ProductFacade productFacade;
    @Resource
    private ImageFormatFacade imageFormatFacade;
    @Resource
    private SortingFacade sortingFacade;

    @GetMapping(RequestMappings.PRODUCTS_BY_CATEGORY + "/{code}")
    public String getByCategory(@PathVariable String code,
                                @RequestParam(required = false) String sorting,
                                Model model) {

        model.addAttribute(Attributes.PRODUCT_LIST, productFacade.findAllByCategory(code, sorting));
        model.addAttribute(Attributes.CATEGORY_CODE, code);
        model.addAttribute(Attributes.SORTING_LIST, sortingFacade.find(Configuration.SORTING_GROUP_KEY, sorting));
        model.addAttribute(Attributes.IMAGE_FORMAT, imageFormatFacade.getFormat(Configuration.IMAGE_FORMAT_KEY));

        return Pages.PRODUCT_LIST_PAGE;
    }
}
