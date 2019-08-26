package com.soft.storecore.controller;


import com.soft.storecore.facade.CategoryFacade;
import com.soft.storecore.facade.ProductFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

import static com.soft.storecore.controller.ControllerConstants.*;

@Controller
@RequestMapping(RequestMappings.PRODUCT_LIST)
public class ProductListPageController {

    @Resource
    private ProductFacade productFacade;

    @Resource
    private CategoryFacade categoryFacade;

    @GetMapping("{id}")
    public String getProductsPage(@PathVariable  Long id, Model model) {
        model.addAttribute(Attributes.PRODUCT_LIST, productFacade.findAllByCategoryId(id));
        model.addAttribute(Attributes.CATEGORIES, categoryFacade.findAll());
        return Pages.PRODUCT_LIST_PAGE;
    }

}
